package com.blog.repository;

import com.blog.model.blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface blogRepository extends JpaRepository<blog,Integer> {
}
