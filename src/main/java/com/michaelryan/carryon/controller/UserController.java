package com.michaelryan.carryon.controller;

import com.michaelryan.carryon.dto.UserDto;
import com.michaelryan.carryon.entity.User;
import com.michaelryan.carryon.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

/**
 * This class defines the Controller for the User Entity which controls
 * navigation to endpoints that require a User Entity DTO
 */
@org.springframework.stereotype.Controller
public class UserController {

    /**
     * Attribute that declares for UserService class
     */
    private UserService userService;

    /**
     * constructor
     */
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Method mapped to index GET endpoint
     */
    @GetMapping("/index")
    public String index() {
        return "index";
    }

    /**
     * Method mapped to home/index GET endpoint
     */
    @GetMapping("/")
    public String home() {
        return "index";
    }

    /**
     * Method mapped to about GET endpoint
     */
    @GetMapping("/about")
    public String aboutUs() {
        return "about";
    }

    /**
     * Method mapped to auction GET endpoint
     */
    @GetMapping("/auction")
    public String auction() {
        return "auction";
    }

    /**
     * Method mapped to contact GET endpoint
     */
    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }

    /**
     * Method mapped to login GET endpoint
     */
    @GetMapping("/login")
    public String login(Model model) {
        UserDto userDto = new UserDto();
        model.addAttribute("userDto", userDto);
        return "login";
    }

    /**
     * Method mapped to login POST endpoint
     */
    @GetMapping("/login/save")
    public String loginUser(Model model) {
        UserDto userDto = new UserDto();
        model.addAttribute("userDto", userDto);
        return "login";
    }

    /**
     * Method mapped to error GET endpoint
     */
    @GetMapping("/error")
    public String error() {
        return "error";
    }

    /**
     * Method mapped to privacy GET endpoint
     */
    @GetMapping("/privacy")
    public String privacy() {
        return "privacy";
    }

    /**
     * Method mapped to profile GET endpoint
     */
    @GetMapping("/profile")
    public String profile() {
        return "profile";
    }

    /**
     * Method mapped to purchase GET endpoint
     */
    @GetMapping("/purchase")
    public String purchase() {
        return "purchase";
    }

    /**
     * Method mapped to register GET endpoint
     */
    @GetMapping("register")
    public String registrationForm(Model model) {
        UserDto userDto = new UserDto();
        model.addAttribute("userDto", userDto);
        return "register";
    }

    /**
     * Method mapped to register POST endpoint
     */
    @PostMapping("register/save")
    public String registration(@Valid @ModelAttribute("user") UserDto userDto,
                               BindingResult bindingResult, Model model) {
        User existing = userService.findByEmail(userDto.getEmail());
        if (existing != null) {
            bindingResult.rejectValue("email", null, "Email already exists");
        }
        if (bindingResult.hasErrors()) {
            model.addAttribute("userDto", userDto);
            return "register";
        }
        userService.saveUser(userDto);
        return "redirect:/login";
    }

    /**
     * Method mapped to register GET endpoint
     */
    @GetMapping("retrieve")
    public String passwordRetrievalForm(Model model) {
        UserDto userDto = new UserDto();
        model.addAttribute("userDto", userDto);
        return "retrieve";
    }

    /**
     * Method mapped to register POST endpoint
     */
    @PostMapping("retrieve/save")
    public String retrievePassword(@Valid @ModelAttribute("user") UserDto userDto,
                               BindingResult bindingResult, Model model) {
        User existing = userService.findByEmail(userDto.getEmail());
        if (existing != null) {
            bindingResult.rejectValue("email", null, "Email already exists");
        }
        if (bindingResult.hasErrors()) {
            model.addAttribute("userDto", userDto);
            return "retrieve";
        }
        userService.saveUser(userDto);
        return "redirect:/retrieve?success";
    }

    /**
     * Method mapped to user_agreement endpoint
     */
    @GetMapping("/user_agreement")
    public String userAgreement() {
        return "user_agreement";
    }
}