package com.blog.repository;

import com.blog.model.AdminContacts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface adminRepository extends JpaRepository<AdminContacts,Integer> {
}
