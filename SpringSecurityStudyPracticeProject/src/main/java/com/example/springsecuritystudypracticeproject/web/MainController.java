package com.example.springsecuritystudypracticeproject.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @GetMapping("/index")
    public String home(){
        return "index";
    }
    @GetMapping("/users")
    public String users(){
        return "users";
    }
    @GetMapping("/success")
    public String success(){
        return "success";
    }
}
