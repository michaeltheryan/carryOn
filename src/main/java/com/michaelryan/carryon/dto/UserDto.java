package com.michaelryan.carryon.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class UserDto {
    private int id;

    @NotEmpty(message = "Email required")
    @Email
    private String email;

    @NotEmpty(message = "Password required")
    private String password;

    @NotEmpty
    private ZonedDateTime created;
}
