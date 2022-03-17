package com.blog.service;

import com.blog.model.AdminContacts;
import com.blog.repository.adminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class adminService {
    @Autowired
    adminRepository adminRepository;

    public AdminContacts create(AdminContacts adminContacts){
        return adminRepository.save(adminContacts);
    }

    public List<AdminContacts> getAll(){
        return adminRepository.findAll();
    }

    public AdminContacts getById(int id){
        return adminRepository.findById(id).get();
    }

    public void delete(int id){
        adminRepository.deleteById(id);
    }

    public AdminContacts update(AdminContacts a){
        AdminContacts b = adminRepository.findById(a.getId()).get();
        if(a.getAddress() != b.getAddress()){
            b.setAddress(a.getAddress());
        }
        if(a.getEmail() != b.getEmail()){
            b.setEmail(a.getEmail());
        }
        if(a.getMap() != b.getMap()){
            b.setMap(a.getMap());
        }
        if(a.getNumber() != b.getNumber()){
            b.setNumber(a.getNumber());
        }
        return adminRepository.save(b);
    }
}
