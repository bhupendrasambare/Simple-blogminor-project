package com.blog.controler;

import com.blog.dto.userDTO;
import com.blog.model.users;
import com.blog.security.userServiceImplimantation;
import com.blog.service.blogService;
import com.blog.service.linkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class account {

    @Autowired
    linkService linkService;

    @Autowired
    userServiceImplimantation userService;

    @Autowired
    com.blog.service.categoriesService categoriesService;

    @Autowired
    com.blog.service.blogService blogService;

    @GetMapping("/user")
    public String user(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = authentication.getName();
        model.addAttribute("user",userService.findByEmail(currentUserName));
        model.addAttribute("link",linkService.getAll());
        model.addAttribute("blog",blogService.getByEmail(currentUserName));
        return "user";
    }

    @GetMapping("/account/{id}")
    public String getUser(@PathVariable("id")int id,Model model){
        if(userService.getById(id)==null){
            return "redirect:/";
        }
        model.addAttribute("user",userService.getById(id));
        model.addAttribute("link",linkService.getAll());
        model.addAttribute("blog",blogService.getByEmail(userService.getById(id).getEmail()));
        return "account";
    }

    @GetMapping("/edit")
    public String edit(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = authentication.getName();
        model.addAttribute("user",userService.findByEmail(currentUserName));
        model.addAttribute("link",linkService.getAll());
        model.addAttribute("categories",categoriesService.getall());
        return "editUser";
    }

    @PostMapping("/edit")
    public String editPost(@RequestParam("name") String name,
                           @RequestParam("email") String email,
                           @RequestParam("dob") String dob,
                           @RequestParam("bio") String bio,
                           @RequestParam("categories")int categories){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        users account = userService.findByEmail(username);
        int cat = (categories ==0)?account.getCategories().getId():categories;
        userDTO user = new userDTO(account.getId(),name,email,account.getPassword(),cat,bio,"",dob);
        userService.update(user);
        if(email != username){
            return "redirect:/logout";
        }
        return "redirect:/user";
    }
}