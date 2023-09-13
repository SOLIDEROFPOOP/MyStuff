package kapparov.murat.jpaauthorization.AuthorizationStudy.Repository;

import kapparov.murat.jpaauthorization.AuthorizationStudy.Model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.parameters.P;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserRepositoryTest {
    @Autowired
    public UserRepository repository;
    @Autowired
    public PasswordEncoder encoder;

    @Test
    public void insert(){
        User user = new User("test" , encoder.encode("test"), "ROLE_ADMIN");
        repository.save(user);
    }
}