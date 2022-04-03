package com.blog.security;

import com.blog.dto.userDTO;
import com.blog.model.Role;
import com.blog.model.categories;
import com.blog.model.users;
import com.blog.repository.usersRepository;
import com.blog.service.categoriesService;
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

    @Autowired
    categoriesService categoriesService;

    public users update(userDTO a){
        users b = usersRepository.findById(a.getId()).get();
        if(a.getName() != b.getName()){
            b.setName(a.getName());
        }
        if(a.getBio() != b.getBio()){
            b.setBio(a.getBio());
        }
        if(a.getCategories_id() != b.getCategories().getId()){
            b.setCategories(categoriesService.getById(a.getCategories_id()));
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
        Optional<users> user = usersRepository.findById(id);
        if(user.isPresent()){
            return user.get();
        }
        return null;
    }

    public void delete(int id){
        usersRepository.deleteById(id);
    }

    public users create(userDTO user) {
        users u = new users(user.getId(),user.getName(),user.getEmail(),user.getPassword(),categoriesService.getById(user.getCategories_id()),user.getBio(),user.getImage(),user.getDob(),null);
        return usersRepository.save(u);
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
