package com.example.proj.Controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class MainController {
    @GetMapping("/basic")
    public String basic(){
        return "okj";
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/admin")
    public String admin(Principal principal){
        return "hello admin name:" + principal.getName();
    }
    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/user")
    public String user(Principal principal){
        return "hello user name:" + principal.getName();
    }
}
