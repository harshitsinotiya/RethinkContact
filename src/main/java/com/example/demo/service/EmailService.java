package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Contact;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Async  // sends email in background
    public void sendEmail(Contact contact) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(contact.getEmail());
        message.setCc("20.rethink.25@gmail.com");

        message.setSubject("Your Detail Registered: " + contact.getName());
        message.setText(
            "Your Details:\n\n" +
            "Name: " + contact.getName() + "\n" +
            "Email: " + contact.getEmail() + "\n" +
            "Company: " + contact.getCompany() + "\n" +
            "Website: " + contact.getWebsite() + "\n" +
            "Project Type: " + contact.getProjectType() + "\n" +
            "Timeframe: " + contact.getTimeframe() + "\n" +
            "Message: " + contact.getMessage()
        );

        mailSender.send(message);
    }
}
