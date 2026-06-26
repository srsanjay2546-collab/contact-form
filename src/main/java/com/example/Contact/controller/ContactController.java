package com.example.Contact.controller;

import com.example.Contact.ContactRepository;
import com.example.Contact.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ContactController {

    @Autowired
    private ContactRepository contactRepository;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/contact")
    public String contactRedirect() {
        return "index";
    }

    @GetMapping("/admin")
    public String admin() {
        return "redirect:/contacts.html";
    }

    @PostMapping("/contact")
    @ResponseBody
    public String handleContact(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String message) {

        Contact contact = new Contact(name, email, message);
        contactRepository.save(contact);
        System.out.println("Saved to DB: " + contact);

        return "Form submitted and saved to database!";
    }

    @GetMapping("/contacts")
    @ResponseBody
    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }
}