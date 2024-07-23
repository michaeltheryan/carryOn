package com.michaelryan.carryon.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * This class defines the attributes for User Data Transfer Objects which
 * are used to carry multiple data attributes between processes
 */
@Data
public class UserDto {
    private int id;

    @NotEmpty(message = "Email required")
    @Email
    private String email;

    @NotEmpty(message = "Password required")
    private String password;

    private LocalDateTime created;
}
