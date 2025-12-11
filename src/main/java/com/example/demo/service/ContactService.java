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

    // Save + Send Email
    public Contact save(Contact contact) {
        Contact saved = repo.save(contact);
        emailService.sendEmail(saved); // async call
        return saved;
    }

    // Get contact by ID
    public Contact getContactById(Long id) {
        return repo.findById(id).orElse(null);
    }
}
