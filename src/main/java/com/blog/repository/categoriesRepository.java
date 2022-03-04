package com.blog.repository;

import com.blog.model.categories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface categoriesRepository extends JpaRepository<categories,Integer> {
}
