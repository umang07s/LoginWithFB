package com.example.registrationlogindemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FixController {

    @GetMapping("/abc")
    public String home(Model model) {
        model.addAttribute("title", "Home Page");
        model.addAttribute("pageTitle", "Welcome to the Home Page");
//        model.addAttribute("content", "home.html :: content");
        return "layout";
    }

    @RequestMapping("/login")
    public String loginPage(){
        return "auth-login";
    }

    @RequestMapping("/home")
    public String loginSubmit(){
        return "/pages/landing_page";
    }
}
