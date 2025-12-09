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

    public Contact saveProject(Contact project) {
        Contact savedContact = repo.save(project);
        
        // Send email in background (non-blocking 🚀)
        emailService.sendEmail(savedContact);

        return savedContact;
    }

    public Contact getContactById() {
        return repo.findById(1L).orElse(null);
    }
}
