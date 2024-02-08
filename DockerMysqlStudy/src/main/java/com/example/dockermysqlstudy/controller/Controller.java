package com.example.dockermysqlstudy.controller;

import com.example.dockermysqlstudy.entity.User;
import com.example.dockermysqlstudy.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    private UserRepo userRepo;
    @GetMapping("/test")
    public List<User> returnAll(){
        return userRepo.findAll();
    }
    @GetMapping()
    public String re(){
        return "sex";
    }
}
