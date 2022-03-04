package com.blog.repository;

import com.blog.model.comments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface commentsRepository extends JpaRepository<comments,Integer> {
}
