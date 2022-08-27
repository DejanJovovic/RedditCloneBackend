package reddit.clone.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import reddit.clone.model.domain.Reaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReactionRepository extends JpaRepository<Reaction, Long> {

    List<Reaction> findAllById(Long id);

    @Query("select r from reactions r where r.post.postId =?1 and r.users.Id=?2")
    public Reaction findByUserId(Long postId, Long id);

}
