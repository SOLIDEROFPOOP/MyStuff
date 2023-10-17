package com.example.project.security;

import com.example.project.data.User;
import com.example.project.models.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class RegistrationController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @GetMapping
    public String register(User user){
        return "register";
    }
    @PostMapping
    public String register(@Valid User user, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            return "register";
        }
        if (!user.getPassword().equals(user.getConfirmPassword())){
            model.addAttribute("passwordMatchProblem", "Passwords Do Not Match");
            return "register";
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "redirect:/login";
    }
}
