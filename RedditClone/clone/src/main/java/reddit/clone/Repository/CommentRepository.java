package reddit.clone.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import src.main.java.reddit.clone.model.domain.Comment;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findAllByPatientId(Long id);
}
