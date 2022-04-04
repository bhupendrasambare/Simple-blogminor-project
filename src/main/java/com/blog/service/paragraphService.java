package com.blog.service;

import com.blog.model.paragraph;
import com.blog.repository.paragraphRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class paragraphService {

    @Autowired
    paragraphRepository paragraphRepository;

    public List<paragraph> getall(){
        return paragraphRepository.findAll();
    }

    public paragraph create(paragraph paragraph){
        return paragraphRepository.save(paragraph);
    }

    public List<paragraph> getByBlog_id(int id){
        return paragraphRepository.findByBlog_Id(id);
    }
}
