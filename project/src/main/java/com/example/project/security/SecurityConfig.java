package com.example.project.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Service;

@Service
@EnableWebSecurity
public class SecurityConfig {
    private final UserRepositoryUserDetailsService userRepositoryUserDetailsService;
    @Bean
    public PasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }

    public SecurityConfig(UserRepositoryUserDetailsService userRepositoryUserDetailsService){
        this.userRepositoryUserDetailsService = userRepositoryUserDetailsService;
    }
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        return http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/category/**").hasAnyRole("USER","ADMIN")
                        .requestMatchers("/admin/**").hasAnyRole("ADMIN")
                        .requestMatchers("/").permitAll()
                        .requestMatchers("/login").permitAll()
                )
                .formLogin(formLogin -> formLogin.loginPage("/login").permitAll())
                .logout(logout -> logout.logoutUrl("/logout").logoutSuccessUrl("/"))
                .exceptionHandling(exceptionHandling -> exceptionHandling.accessDeniedPage("/"))
                .build();
    }
}
