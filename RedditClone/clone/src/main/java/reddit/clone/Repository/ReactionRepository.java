package reddit.clone.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import reddit.clone.model.domain.Reaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReactionRepository extends JpaRepository<Reaction, Long> {

    List<Reaction> findAllById(Long id);
}
