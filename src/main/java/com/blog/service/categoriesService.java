package com.blog.service;

import com.blog.model.categories;
import com.blog.repository.categoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class categoriesService {
    @Autowired
    categoriesRepository categoriesRepository;

    public categories create(categories categorie){
        return categoriesRepository.save(categorie);
    }

    public categories update(categories a){
        categories b = categoriesRepository.findById(a.getId()).get();
        if(a.getName() != b.getName()){
            b.setName(a.getName());
        }
        if(a.getImage() != b.getImage()){
            b.setImage(a.getImage());
        }
        return categoriesRepository.save(b);
    }

    public List<categories> getall(){
        return categoriesRepository.findAll();
    }

    public categories getById(int id){
        return categoriesRepository.findById(id).get();
    }

    public void delete(int id){
        categoriesRepository.deleteById(id);
    }
}
