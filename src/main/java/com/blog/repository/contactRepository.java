package com.blog.repository;

import com.blog.model.contacts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface contactRepository extends JpaRepository<contacts,Integer> {
}
