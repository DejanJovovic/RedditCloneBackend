package reddit.clone.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import reddit.clone.model.domain.Banned;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BannedRepository extends JpaRepository<Banned, Long> {

    List<Banned> findAllById(Long id);
}
