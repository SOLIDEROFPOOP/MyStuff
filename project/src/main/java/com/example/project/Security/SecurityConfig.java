package com.example.project.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Service;

@Service
public class SecurityConfig{

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    /*
     @Override
     protected void configure(HttpSecurity http) throws Exception {
         /*
         http
             .authorizeRequests()
                 .antMatchers("/category/**").hasAnyRole("USER", "ADMIN")
                 .antMatchers("/admin/**").hasAnyRole("ADMIN")
                 .antMatchers("/").permitAll()
                     .and()
                         .formLogin()
                             .loginPage("/login")
                     .and()
                         .logout()
                             .logoutSuccessUrl("/")
                     .and()
                         .exceptionHandling()
                             .accessDeniedPage("/");
                 // .antMatchers("/**").hasAnyRole("USER");

         // http
         //     .authorizeRequests()
         //         .antMatchers("/category/**").access("hasRole('ROLE_USER')")
         //         .antMatchers("/").access("permitAll");
     }
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        return http
                .authorizeHttpRequests((authorize)->
                        authorize

                                .requestMatchers("/category/**").hasAnyRole("USER" , "ADMIN")
                                .requestMatchers("/admin/**").hasRole("ADMIN")

                                .requestMatchers("/**").permitAll()
                ).formLogin(
                        form -> form
                                .loginPage("/login")
                                .loginProcessingUrl("/login")
                                .defaultSuccessUrl("/category/all")
                                .permitAll()
                ).logout(
                        logout -> logout
                                .logoutSuccessUrl("/")
                ).exceptionHandling(
                        exception -> exception
                                .accessDeniedPage("/")
                ).build();

    }
}