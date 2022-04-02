package com.blog.controler;

import com.blog.security.userServiceImplimantation;
import com.blog.service.linkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class singlePage {

    @Autowired
    linkService linkService;

    @Autowired
    userServiceImplimantation userService;

    @GetMapping("/user")
    public String user(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = authentication.getName();
        model.addAttribute("user",userService.findByEmail(currentUserName));
        model.addAttribute("link",linkService.getAll());
        return "user";
    }

}