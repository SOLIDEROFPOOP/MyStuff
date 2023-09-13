package net.jwtStudy.JWTStudy.Repository;

import net.jwtStudy.JWTStudy.Model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role , Long> {
    Role findByName(String name);
}
