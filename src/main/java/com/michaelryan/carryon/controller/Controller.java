package com.michaelryan.carryon.controller;

import com.michaelryan.carryon.dto.UserDto;
import com.michaelryan.carryon.entity.User;
import com.michaelryan.carryon.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@org.springframework.stereotype.Controller
public class Controller {

    private UserService userService;

    @Autowired
    public Controller(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/about")
    public String aboutUs() {
        return "about";
    }

    @GetMapping("/auction")
    public String auction() {
        return "auction";
    }

    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }

    @GetMapping("/login")
    public String login(Model model) {
        UserDto userDto = new UserDto();
        model.addAttribute("userDto", userDto);
        return "login";
    }

    @GetMapping("/error")
    public String error() {
        return "error";
    }

    @GetMapping("/privacy")
    public String privacy() {
        return "privacy";
    }

    @GetMapping("/profile")
    public String profile() {
        return "profile";
    }

    @GetMapping("/purchase")
    public String purchase() {
        return "purchase";
    }

    @GetMapping("register")
    public String registrationForm(Model model) {
        UserDto userDto = new UserDto();
        model.addAttribute("userDto", userDto);
        return "register";
    }

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
        return "redirect:/register?success";
    }

    @GetMapping("/search")
    public String search() {
        return "search";
    }

    @GetMapping("/search_results")
    public String searchResults() {
        return "search_results";
    }

    @GetMapping("/user_agreement")
    public String userAgreement() {
        return "user_agreement";
    }

}
