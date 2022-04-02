package com.blog.security;

import com.blog.dto.userDTO;
import com.blog.model.Role;
import com.blog.model.users;
import com.blog.repository.usersRepository;
import com.blog.service.usersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class userServiceImplimantation implements usersService {
    @Autowired
    usersRepository usersRepository;

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

    @Override
    public users create(userDTO user) {
        return usersRepository.save(user);
    }

    public users findByEmail(String email){
        return usersRepository.findByEmail(email);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        users user  = usersRepository.findByEmail(username);
        if(user == null){
            throw new UsernameNotFoundException("invalid email Password");
        }
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        grantedAuthorities.add(new SimpleGrantedAuthority("USER"));
        return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(), grantedAuthorities);
    }
}
