package kapparov.murat.jpaauthorization.AuthorizationStudy.Repository;

import kapparov.murat.jpaauthorization.AuthorizationStudy.Model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post , Long> {

}
