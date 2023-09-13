package kapparov.murat.jpaauthorization.AuthorizationStudy.Repository;

import kapparov.murat.jpaauthorization.AuthorizationStudy.Model.Post;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PostRepositoryTest {
    @Autowired
    public PostRepository repository;

    @Test
    public void insert(){
        Post post = new Post("title" , "slug" , "content" , "author");
        repository.save(post);
    }
}