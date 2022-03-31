package com.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class emailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendEmail(String email,String subject,String body){
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setFrom("bhupendrasamips1924@gmail.com");
        mail.setTo(email);
        mail.setSubject(subject);
        mail.setText(body);
        javaMailSender.send(mail);
    }
}
