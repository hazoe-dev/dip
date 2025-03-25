package com.example.dip.business.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {
    @GetMapping("/welcome")
    public String showPage(Model model) {
        model.addAttribute("message", "Hello from Thymeleaf!");
        return "welcome";
    }
}
