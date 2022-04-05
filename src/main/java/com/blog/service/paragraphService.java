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
        List<paragraph> par = paragraphRepository.findAll();
        for(int i=0;i<par.size();i++){
            par.get(i).setData(par.get(i).getData().replace("^","'"));
            par.get(i).setData(par.get(i).getData().replace('*','"'));
        }
        return par;
    }

    public paragraph create(paragraph paragraph){
        paragraph.setData(paragraph.getData().replace("'","^"));
        paragraph.setData(paragraph.getData().replace('"','*'));
        return paragraphRepository.save(paragraph);
    }

    public List<paragraph> getByBlog_id(int id){
        List<paragraph> par = paragraphRepository.findByBlog_Id(id);
        for(int i=0;i<par.size();i++){
            par.get(i).setData(par.get(i).getData().replace("^","'"));
            par.get(i).setData(par.get(i).getData().replace('*','"'));
        }
        return par;
    }
}
