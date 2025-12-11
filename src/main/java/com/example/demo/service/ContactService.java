package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Contact;
import com.example.demo.repository.ContactRepo;

@Service
public class ContactService {

    @Autowired
    private ContactRepo repo;

    @Autowired
    private EmailService emailService;

    public Contact saveContact(Contact contact) {

        // Save contact in DB
        Contact saved = repo.save(contact);

        // Send email asynchronously
        emailService.sendEmail(saved);

        return saved;
    }

    public Contact getContactById(Long id) {
        return repo.findById(id).orElse(null);
    }
}
