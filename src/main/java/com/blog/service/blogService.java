package com.blog.service;

import com.blog.model.blog;
import com.blog.repository.blogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class blogService {
    @Autowired
    blogRepository blogRepository;

    public blog create(blog blog){
        return blogRepository.save(blog);
    }

    public List<blog> getAll(){
        return blogRepository.findAll();
    }

    public blog getBlogById(int id){
        Optional<blog> blog = blogRepository.findById(id);
        if(blog.isPresent()){
            return blog.get();
        }
        return null;
    }

    public void delete(int id){
        blogRepository.deleteById(id);
    }

    public blog update(blog b){
        blog a = blogRepository.getById(b.getId());
        if(a.getCategories() != b.getCategories()){
            a.setCategories(b.getCategories());
        }
        if(a.getImage() != b.getImage()){
            a.setImage(b.getImage());
        }
        if(a.getDate() != b.getDate()){
            a.setDate(b.getDate());
        }
        if(a.getHashtag() != b.getHashtag()){
            a.setHashtag(b.getHashtag());
        }
        if(a.getName() != b.getName()){
            a.setName(b.getName());
        }
        return blogRepository.save(a);
    }

    public List<blog> getByCategories(String name){
        return blogRepository.findByCategories_NameIgnoreCase(name);
    }

    public List<blog> getRecent(){
        List<blog> recent = new ArrayList<blog>();
        int i=0;
        for(com.blog.model.blog b : blogRepository.findAll()){
            recent.add(b);i++;
            if(i>=6) {
                break;
            }
        }
        return recent;
    }
}
