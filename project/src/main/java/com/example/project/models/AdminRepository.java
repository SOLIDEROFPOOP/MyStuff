package com.example.project.models;

import com.example.project.data.Admin;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin , Integer> {
    Admin findByUsername(String username);
}
