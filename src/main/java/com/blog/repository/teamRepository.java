package com.blog.repository;

import com.blog.model.teams;
import org.springframework.data.jpa.repository.JpaRepository;

public interface teamRepository extends JpaRepository<teams,Integer> {
}
