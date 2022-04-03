package com.blog.repository;

import com.blog.dto.userDTO;
import com.blog.model.users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface usersRepository extends JpaRepository<users,Integer> {
    users findByEmail(String email);
    Optional<users> findById(int id);
}
