package com.blog.repository;


import com.blog.model.paragraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface paragraphRepository extends JpaRepository<paragraph, Integer> {
    List<paragraph> findByBlog_Id(int id);
}
