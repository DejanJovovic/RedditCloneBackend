package reddit.clone.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import src.main.java.reddit.clone.model.domain.Flair;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlairRepository extends JpaRepository<Flair, Long> {

    List<Flair> findAllByPatientId(Long id);
}
