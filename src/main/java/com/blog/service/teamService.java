package com.blog.service;

import com.blog.model.teams;
import com.blog.repository.teamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class teamService {
    @Autowired
    teamRepository teamRepository;

    public teams create(teams team){
        return teamRepository.save(team);
    }

    public teams update(teams a){
        teams b = teamRepository.findById(a.getId()).get();
        if(a.getName() != b.getName()){
            b.setName(a.getName());
        }
        if(a.getEmail() != b.getEmail()){
            b.setEmail(a.getEmail());
        }
        if(a.getGithub() != b.getGithub()){
            b.setGithub(a.getGithub());
        }
        if(a.getImage() != b.getImage()){
            b.setImage(a.getImage());
        }
        if(a.getLinkedin() != b.getLinkedin()){
            b.setLinkedin(a.getLinkedin());
        }
        return teamRepository.save(b);
    }

    public List<teams> getAll(){
        return teamRepository.findAll();
    }

    public teams getById(int id){
        return teamRepository.getById(id);
    }

    public void delete(int id){
        teamRepository.deleteById(id);
    }
}
