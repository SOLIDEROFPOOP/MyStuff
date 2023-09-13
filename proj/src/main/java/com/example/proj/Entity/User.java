package com.example.proj.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@ToString
@Getter
@Setter
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "user_id_generator")
    @SequenceGenerator(name = "user_id_generator", sequenceName = "user_id_sequence", allocationSize = 1)
    private Long id;
    private String username;
    private String password;
    private String roles;
    public User(String username , String password , String roles){
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

}
