package com.example.dockermysqlstudy.repository;

import com.example.dockermysqlstudy.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
}
