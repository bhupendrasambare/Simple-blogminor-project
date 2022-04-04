package com.blog.controler;

import com.blog.model.blog;
import com.blog.model.contacts;
import com.blog.model.paragraph;
import com.blog.model.users;
import com.blog.security.userServiceImplimantation;
import com.blog.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.SpringSessionContext;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
public class pagePost {

    @Autowired
    emailService emailService;

    @Autowired
    contactService contactService;

    @Autowired
    operations operations;

    @Autowired
    linkService linkService;

    @Autowired
    blogService blogService;

    @Autowired
    userServiceImplimantation usersService;

    @Autowired
    paragraphService paragraphService;

    @Autowired
    categoriesService categoriesService;

    @GetMapping("/add")
    public String blog(Model model){
        model.addAttribute("link",linkService.getAll());
        model.addAttribute("categories",categoriesService.getall());
        model.addAttribute("heading","Add New Blog");
        return "addBlog";
    }

    @PostMapping("/add")
    public String addBlog(@RequestParam("name")String name,
                          @RequestParam("tag")String tag,
                          @RequestParam("image") MultipartFile image,
                          @RequestParam("categories")int categories,
                          @RequestParam("paragraph[]")List<String> par) throws IOException {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        users user = usersService.findByEmail(username);
        String imgname = operations.saveImage(image,"blog");
        blog blog = new blog(0,name,tag,imgname,operations.getdate(),0,categoriesService.getById(categories),user);
        blog nblog = blogService.create(blog);
        for (String p:par) {
            p = p.replace("'","^");
            p = p.replace('"','*');
            paragraphService.create(new paragraph(0,nblog,p));
        }
        return "redirect:/user";
    }

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
