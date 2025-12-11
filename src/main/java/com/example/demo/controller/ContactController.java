package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.Contact;
import com.example.demo.service.ContactService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/rcontact")
public class ContactController {

    @Autowired
    private ContactService service;

    @PostMapping("/save")
    public Contact registerProject(@Valid @RequestBody Contact contact) {
        return service.saveProject(contact);
    }

    // No parameters → matches the service method
    @GetMapping("/get-contact")
    public Contact getContactById() {
        return service.getContactById();
    }
}
