package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

    @GetMapping("/get-contact")
    public Contact getContactById() {
        return service.getContactById();
    }
}
