package com.blog.repository;

import com.blog.model.blog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface blogRepository extends JpaRepository<blog,Integer> {
    List<blog> findByUsers_EmailIgnoreCase(String email);

    List<blog> findByCategories_NameIgnoreCase(String name);

    long countByUsers_EmailIgnoreCase(String email);
}
