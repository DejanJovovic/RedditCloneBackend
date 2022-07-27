package reddit.clone.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import src.main.java.reddit.clone.model.domain.Banned;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BannedRepository extends JpaRepository<Banned, Long> {

    List<Banned> findAllByPatientId(Long id);
}
