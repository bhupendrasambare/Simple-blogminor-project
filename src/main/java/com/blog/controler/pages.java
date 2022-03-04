package com.blog.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class pages {

    @GetMapping({"","/","/index"})
    public String index(){
        return "index";
    }

    @GetMapping("/about")
    public String about(){
        return "about";
    }

    @GetMapping("/blog")
    public String blog(){
        return "about";
    }

    @GetMapping("/contact")
    public String contact(){
        return "contact";
    }
}
