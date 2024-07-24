package com.michaelryan.carryon.service.impl;

import com.michaelryan.carryon.dto.UserDto;
import com.michaelryan.carryon.entity.Role;
import com.michaelryan.carryon.entity.User;
import com.michaelryan.carryon.repository.RoleRepository;
import com.michaelryan.carryon.repository.UserRepository;
import com.michaelryan.carryon.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static java.time.ZoneOffset.UTC;

/**
 * This class implements the corresponding service interface and provides the
 * business logic (go-between for the controller/web layer and the data access
 * layer (repository, DAO, etc.) for Auctions
 */
@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    /**
    * constructor
    */
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    /**
     * method to save new Users
     */
    @Override
    public void saveUser(UserDto userDto) {
        User user = new User();
        user.setEmail(userDto.getEmail());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setCreated(LocalDateTime.now(UTC));

        String roleName;
        if(userDto.isAdminRegistration()) {
            roleName = "ROLE_ADMIN";
        } else {
            roleName = "ROLE_USER";
        }
        Role role = roleRepository.findByEmail(roleName);
        if(role == null) {
            role = new Role();
            role.setEmail(roleName);
            roleRepository.save(role);
        }
        user.setRoles(Collections.singletonList(role));
        userRepository.save(user);
    }

    /**
     * method to delete new Users
     */
    public void deleteUser(String email) {
        User user = userRepository.findByEmail(email);
        // logic to remove user from database
        userRepository.save(user);
    }

    /**
     * method to make changes to Users
     */
    public void updateUser(UserDto userDto) {
        User user = userRepository.findByEmail(userDto.getEmail());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        // does above actually change the password?
        // if so, is below needed?
        userRepository.save(user);
    }

    /**
     * method to find Users by email
     */
    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    /**
     * method to find all Users
     */
    @Override
    public List<UserDto> findAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map((user) -> convertEntityToDto(user)).
                collect(Collectors.toList());
    }

    /**
     * method to find all Users with government email addresses
     */
    public List<UserDto> findAllUsersByDomain(String domain) {
        List<User> users = userRepository.findAllUsersByDomain(domain);
        return users.stream().map((user) -> convertEntityToDto(user)).
                collect(Collectors.toList());
    }

    /**
     * method to find all Users  who registered after given date
     */
    public List<UserDto> findAllUsersAfterDate(LocalDateTime date) {
        List<User> users = userRepository.findAllUsersAfterDate(date);
        return users.stream().map((user) -> convertEntityToDto(user)).
                collect(Collectors.toList());
    }

    /**
     * method to find all Users who registered before given date
     */
    public List<UserDto> findAllUsersBeforeDate(LocalDateTime date) {
        List<User> users = userRepository.findAllUsersBeforeDate(date);
        return users.stream().map((user) -> convertEntityToDto(user)).
                collect(Collectors.toList());
    }

    /**
     * method to convert Users to Dtos for client interactions
     */
    private UserDto convertEntityToDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setEmail(user.getEmail());
        userDto.setCreated(user.getCreated());
        return userDto;
    }
}
