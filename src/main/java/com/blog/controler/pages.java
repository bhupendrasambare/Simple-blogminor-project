package com.blog.controler;

import com.blog.service.categoriesService;
import com.blog.service.linkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class pages {

    @Autowired
    linkService linkService;

    @Autowired
    categoriesService categoriesService;

    @GetMapping({"","/","/index"})
    public String index(Model model){
        model.addAttribute("link",linkService.getAll());
        model.addAttribute("categories",categoriesService.getall());
        return "index";
    }

    @GetMapping("/about")
    public String about(Model model){
        model.addAttribute("link",linkService.getAll());
        return "about";
    }

    @GetMapping("/blog")
    public String blog(Model model){
        model.addAttribute("link",linkService.getAll());
        model.addAttribute("categories",categoriesService.getall());
        return "blog";
    }

    @GetMapping("/contact")
    public String contact(Model model){
        model.addAttribute("link",linkService.getAll());
        return "contact";
    }
}
