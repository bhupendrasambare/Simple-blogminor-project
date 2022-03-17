package com.blog.service;

import com.blog.model.links;
import com.blog.repository.linkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class linkService {
    @Autowired
    linkRepository linkRepository;

    public links create(links link){
        return linkRepository.save(link);
    }

    public links update(links a){
        links b = linkRepository.findById(a.getId()).get();
        if(a.getLink() != b.getLink()){
            b.setLink(a.getLink());
        }
        if(a.getName() != b.getName()){
            b.setName(a.getName());
        }
        return linkRepository.save(b);
    }

    public List<links> getAll(){
        return linkRepository.findAll();
    }

    public links getById(int id){
        return linkRepository.getById(id);
    }

    public void delete(int id){
        linkRepository.deleteById(id);
    }

}
