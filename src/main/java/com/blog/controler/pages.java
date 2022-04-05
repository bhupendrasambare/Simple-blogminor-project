package com.blog.controler;

import com.blog.service.blogService;
import com.blog.service.categoriesService;
import com.blog.service.linkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class pages {

    @Autowired
    linkService linkService;

    @Autowired
    categoriesService categoriesService;

    @Autowired
    blogService blogService;

    @GetMapping({"","/","/index"})
    public String index(Model model){
        model.addAttribute("link",linkService.getAll());
        model.addAttribute("categories",categoriesService.getall());
        model.addAttribute("recent",blogService.getRecent());
        return "index";
    }

    @GetMapping("/about")
    public String about(Model model){
        model.addAttribute("link",linkService.getAll());
        return "about";
    }

    @GetMapping("/blog")
    public String blogPage(Model model){
        model.addAttribute("link",linkService.getAll());
        model.addAttribute("categories",categoriesService.getall());
        model.addAttribute("heading","RECENT POSTS");
        model.addAttribute("subheading","OUR RECENT BLOG ENTRIES");
        model.addAttribute("blog",blogService.getAll());
        model.addAttribute("recent",blogService.getRecent());
        return "blog";
    }

    @GetMapping("/contact")
    public String contact(Model model){
        model.addAttribute("link",linkService.getAll());
        return "contact";
    }
}
