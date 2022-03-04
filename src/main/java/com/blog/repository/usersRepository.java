package com.blog.repository;

import com.blog.model.users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface usersRepository extends JpaRepository<users,Integer> {
}
