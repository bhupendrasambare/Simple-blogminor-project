package com.blog.service;

import com.blog.model.comments;
import com.blog.repository.commentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class commentsService {
    @Autowired
    commentsRepository commentsRepository;

    public comments create(comments comment){
        return commentsRepository.save(comment);
    }

    public comments update(comments a){
        comments b = commentsRepository.findById(a.getId()).get();
        if(a.getText() != b.getText()){
            b.setText(a.getText());
        }
        return commentsRepository.save(b);
    }

    public List<comments> getAll(){
        return commentsRepository.findAll();
    }

    public comments getById(int id){
        return commentsRepository.findById(id).get();
    }

    public void delete(int id){
        commentsRepository.deleteById(id);
    }
}
