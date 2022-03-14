package com.blog.service;

import com.blog.model.blog;
import com.blog.repository.blogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class blogService {
    @Autowired
    blogRepository blogRepository;

    public blog create(blog blog){
        return blogRepository.save(blog);
    }

    public List<blog> getBlog(){
        return blogRepository.findAll();
    }

    public blog getBlogById(int id){
        return  blogRepository.getById(id);
    }

    public void delete(int id){
        blogRepository.deleteById(id);
    }

    public blog update(blog b){
        blog a = blogRepository.getById(b.getId());
        if(a.getCategories() != b.getCategories()){
            a.setCategories(b.getCategories());
        }
        if(a.getData() != b.getData()){
            a.setData(b.getData());
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

}
