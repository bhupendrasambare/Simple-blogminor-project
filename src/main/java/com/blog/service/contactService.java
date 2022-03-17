package com.blog.service;

import com.blog.model.contacts;
import com.blog.repository.contactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class contactService {
    @Autowired
    contactRepository contactRepository;

    public contacts create(contacts contact){
        return contactRepository.save(contact);
    }

    public List<contacts> getAll(){
        return contactRepository.findAll();
    }
    public contacts getById(int id){
        return contactRepository.findById(id).get();
    }
    public void delete(int id){
        contactRepository.deleteById(id);
    }
}
