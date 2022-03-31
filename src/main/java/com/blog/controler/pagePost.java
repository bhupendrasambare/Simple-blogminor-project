package com.blog.controler;

import com.blog.model.contacts;
import com.blog.service.contactService;
import com.blog.service.emailService;
import com.blog.service.operations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class pagePost {

    @Autowired
    emailService emailService;

    @Autowired
    contactService contactService;

    @Autowired
    operations operations;

    @PostMapping("/contact")
    public String sendEmail(@RequestParam("name")String name,
                            @RequestParam("email")String email,
                            @RequestParam("subject")String subject,
                            @RequestParam("message")String message){
        emailService.sendEmail(email,"regarding "+subject,name+" Thank you for your time. we will shurely look after you");
        emailService.sendEmail("bhupendrasam1404@gmail.com",subject+" from "+name, message);
        contactService.create(new contacts(0,name,email,subject,message,operations.getdate()));
        return "redirect:/contact";
    }
}
