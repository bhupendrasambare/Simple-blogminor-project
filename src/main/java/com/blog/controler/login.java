package com.blog.controler;

import com.blog.dto.userDTO;
import com.blog.model.users;
import com.blog.security.userServiceImplimantation;
import com.blog.service.categoriesService;
import com.blog.service.usersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class login {

    @Autowired
    categoriesService categoriesService;

    @Autowired
    userServiceImplimantation usersService;

    @GetMapping("/login")
    public String login(){
        return "login/login";
    }

    @GetMapping("/register")
    public String regster(Model model){
        model.addAttribute("categories",categoriesService.getall());
        return "login/register";
    }

    @PostMapping("/register")
    public String saveRegister(
            @RequestParam("name")String name,
            @RequestParam("email")String email,
            @RequestParam("password")String password,
            @RequestParam("bio")String bio,
            @RequestParam("dob")String date,
            @RequestParam("categories")String categories){
        //System.out.println(date);
        userDTO user = new userDTO(0,name,email,password,Integer.parseInt(categories),bio,"",date);
        usersService.create(user);
        return "redirect:/login";
    }
}
