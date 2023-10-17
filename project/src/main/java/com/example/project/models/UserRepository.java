package com.example.project.models;

import com.example.project.data.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
        User findByUsername(String username);
}
