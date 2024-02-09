package com.example.dockerstudy;

import com.example.dockerstudy.User;
import com.example.dockerstudy.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    @GetMapping("/add")
    public void addTestUser(){
        User user = new User();
        user.setId(15l);
        user.setEmail("fr");
        user.setUsername("bro");
        
    }
}
