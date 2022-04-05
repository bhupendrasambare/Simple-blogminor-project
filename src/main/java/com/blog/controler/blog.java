package com.blog.controler;

import com.blog.model.paragraph;
import com.blog.service.blogService;
import com.blog.service.categoriesService;
import com.blog.service.linkService;
import com.blog.service.paragraphService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class blog {

    @Autowired
    categoriesService categoriesService;

    @Autowired
    linkService linkService;

    @Autowired
    blogService blogService;

    @Autowired
    paragraphService paragraphService;

    @GetMapping("/blog/{id}")
    public String blogPage(@PathVariable("id")int id,Model model){
        model.addAttribute("link",linkService.getAll());
        model.addAttribute("categories",categoriesService.getall());
        if(blogService.getBlogById(id) == null){
            return "redirect:/blog";
        }
        model.addAttribute("blog",blogService.getBlogById(id));
        model.addAttribute("paragraphs",paragraphService.getByBlog_id(id));
        model.addAttribute("recent",blogService.getRecent());
        return "post-details";
    }


    @GetMapping("/add")
    public String addBlog(Model model){
        model.addAttribute("link",linkService.getAll());
        model.addAttribute("categories",categoriesService.getall());
        model.addAttribute("heading","Add New Blog");
        return "addBlog";
    }

    @GetMapping("/categories/{name}")
    public String getBlogByCategories(@PathVariable("name")String name,
                                      Model model){
        if(blogService.getByCategories(name).size() <1){
            return "redirect:/";
        }
        model.addAttribute("link",linkService.getAll());
        model.addAttribute("categories",categoriesService.getall());
        model.addAttribute("heading","POSTS RELATED TO  "+name);
        model.addAttribute("subheading","OUR BLOG ENTRIES");
        model.addAttribute("blog",blogService.getByCategories(name));
        model.addAttribute("recent",blogService.getRecent());
        return "blog";
    }
}
