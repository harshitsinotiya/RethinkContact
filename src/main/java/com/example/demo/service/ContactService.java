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

        // Send email async
        emailService.sendEmail(savedContact);

        return savedContact;
    }

    // Always return ID = 1
    public Contact getContactById() {
        return repo.findById(1L).orElse(null);
    }
}
