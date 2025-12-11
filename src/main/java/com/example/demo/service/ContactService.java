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

    // Save + send email
    public Contact saveProject(Contact project) {
        Contact savedContact = repo.save(project);

        // Non-blocking email
        emailService.sendEmail(savedContact);

        return savedContact;
    }

    // Fetch by ID
    public Contact getContactById(Long id) {
        return repo.findById(id).orElse(null);
    }
}
