package com.blog.service;

import com.blog.repository.categoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class categoriesService {
    @Autowired
    categoriesRepository categoriesRepository;
}
