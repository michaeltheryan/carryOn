package com.michaelryan.carryon.service;

import com.michaelryan.carryon.dto.UserDto;
import com.michaelryan.carryon.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * This interface provides the contract for the User Service implementation
 * this provides the business logic for the application and
 * exposes a public contract for the actual service implementation, without
 * implementation details such as private methods or attributes
 */
@Component
public interface UserService {
    /**
     * These methods must be fully implemented in the actual service class
     */
    void saveUser(UserDto userDto);
    User findByEmail(String email);
    List<UserDto> findAllUsers();
}
