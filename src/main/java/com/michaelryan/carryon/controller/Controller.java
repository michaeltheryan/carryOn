package com.michaelryan.carryon.controller;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
public class Controller {
    @GetMapping("index")
    public String index() {
        return "index";
    }
    @GetMapping("about_us")
    public String aboutUs() {
        return "about_us";
    }
    @GetMapping("contact_us")
    public String contactUs() {
        return "contact_us";
    }
    @GetMapping("error")
    public String error() {
        return "error";
    }
    @GetMapping("user_agreement")
    public String userAgreement() {
        return "user_agreement";
    }
    @GetMapping("privacy_notice")
    public String privacyNotice() {
        return "privacy_notice";
    }
}
