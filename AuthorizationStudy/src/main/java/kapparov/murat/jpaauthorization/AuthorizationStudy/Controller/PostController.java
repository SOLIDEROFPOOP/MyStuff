package kapparov.murat.jpaauthorization.AuthorizationStudy.Controller;

import kapparov.murat.jpaauthorization.AuthorizationStudy.Model.Post;
import kapparov.murat.jpaauthorization.AuthorizationStudy.Repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    private final PostRepository postRepository;
    @Autowired
    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }
    @GetMapping()
    public Iterable<Post> findAll(){
        return postRepository.findAll();
    }
    @GetMapping("/{id}")
    public Post findById(@PathVariable("id") Post post){
        return post;
    }

}
