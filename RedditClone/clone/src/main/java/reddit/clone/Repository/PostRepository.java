package reddit.clone.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import reddit.clone.model.domain.Post;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findAllById(Long id);

    @Query("select c from posts c where c.postId =? 1")
    Post findOneById(Long postId);

    @Query("select c from posts c where c.communities.id =? 1")
    List<Post> findAllByCommunity(Long id);
}
