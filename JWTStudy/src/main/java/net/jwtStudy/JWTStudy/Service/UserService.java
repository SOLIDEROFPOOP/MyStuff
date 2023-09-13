package net.jwtStudy.JWTStudy.Service;

import net.jwtStudy.JWTStudy.Model.User;

import java.util.List;

public interface UserService {
    User register(User user);
    List<User> getAll();
    User findByUsername(String username);
    User findById(Long id);
    void delete(long id);
}
