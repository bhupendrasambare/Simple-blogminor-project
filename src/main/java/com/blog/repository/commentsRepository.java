package com.blog.repository;

import com.blog.model.comments;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface commentsRepository extends JpaRepository<comments,Integer> {
    List<comments> findByBlog_Id(int id);

}
