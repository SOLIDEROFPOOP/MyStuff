package com.example.springsecuritystudypracticeproject.Service;

import com.example.springsecuritystudypracticeproject.model.User;
import com.example.springsecuritystudypracticeproject.web.DTO.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User save(UserRegistrationDto registrationDto);
}
