package com.example.first.controller;

import com.example.first.EmailRequest;
import com.example.first.EmailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/email")
public class MailMessage {
    @Autowired
    private EmailSender emailSender;
    @PostMapping("/send")
    public String sendEmail(@RequestBody EmailRequest emailRequest) {
        emailSender.sendSimpleEmail(emailRequest.getTo(), emailRequest.getSubject(), emailRequest.getText());
        return "Email sent successfully!";
    }
}
