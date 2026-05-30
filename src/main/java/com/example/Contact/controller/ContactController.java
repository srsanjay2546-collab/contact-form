package com.example.Contact.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ContactController {

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @PostMapping("/contact")
    @ResponseBody
    public String handleContact(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String message) {

        System.out.println("Name: " + name +
                ", Email: " + email +
                ", Message: " + message);

        return "Form submitted successfully!";
    }
}