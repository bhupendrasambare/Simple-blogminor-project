package com.blog.service;

import com.blog.model.links;
import com.blog.model.users;
import com.blog.repository.usersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class usersService {
    @Autowired
    usersRepository usersRepository;

    public users create(users user){
        return usersRepository.save(user);
    }

    public users update(users a){
        users b = usersRepository.findById(a.getId()).get();
        if(a.getName() != b.getName()){
            b.setName(a.getName());
        }
        if(a.getBio() != b.getBio()){
            b.setBio(a.getBio());
        }
        if(a.getCategories() != b.getCategories()){
            b.setCategories(a.getCategories());
        }
        if(a.getDob() != b.getDob()){
            b.setDob(a.getDob());
        }
        if(a.getEmail() != b.getEmail()){
            b.setEmail(a.getEmail());
        }
        if(a.getImage() != b.getImage()){
            b.setImage(a.getImage());
        }
        if(a.getPassword() != b.getPassword()){
            b.setPassword(a.getPassword());
        }
        return usersRepository.save(b);
    }

    public List<users> getAll(){
        return usersRepository.findAll();
    }

    public users getById(int id){
        return usersRepository.getById(id);
    }

    public void delete(int id){
        usersRepository.deleteById(id);
    }
}
