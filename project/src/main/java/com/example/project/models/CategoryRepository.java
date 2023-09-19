package com.example.project.models;

import com.example.project.data.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer>{
    Category findByName(String name);
    List<Category> findAllByOrderBySortingAsc();
}
