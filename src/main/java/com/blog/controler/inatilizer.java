package com.blog.controler;

import com.blog.model.categories;
import com.blog.model.links;
import com.blog.service.categoriesService;
import com.blog.service.linkService;
import com.blog.service.teamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class inatilizer {

    @Autowired
    categoriesService categoriesService;

    @Autowired
    linkService linkService;

    @Autowired
    teamService teamService;

    @PostMapping("/initialize")
    public String database(){
        //Categories Data
        categoriesService.create(new categories(1,"Nature","banner-item-01.jpg"));
        categoriesService.create(new categories(2,"Weather","banner-item-02.jpg"));
        categoriesService.create(new categories(3,"Political","banner-item-03.jpg"));
        categoriesService.create(new categories(4,"Tourism","banner-item-04.jpg"));
        categoriesService.create(new categories(5,"Architecture","banner-item-05.jpg"));

        //link Data
        linkService.create(new links(1,"Twitter","https://twitter.com/bhupendra_SAM"));
        linkService.create(new links(2,"Linkedin","https://www.linkedin.com/in/bhupendrasambare/"));
        linkService.create(new links(3,"Github","https://github.com/bhupendrasambare"));
        linkService.create(new links(4,"Inshttps://www.linkedin.com/in/bhupendrasambare/\ttagram","https://www.instagram.com/bhupendra.sambare/"));

        return "redirect:/index";
    }
}
