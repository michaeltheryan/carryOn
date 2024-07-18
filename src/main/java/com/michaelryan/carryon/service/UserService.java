package com.michaelryan.carryon.service;

import com.michaelryan.carryon.dto.UserDto;
import com.michaelryan.carryon.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserService {
    void saveUser(UserDto userDto);
    User findByEmail(String email);
    List<UserDto> findAllUsers();
}
