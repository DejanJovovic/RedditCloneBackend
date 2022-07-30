package reddit.clone.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import reddit.clone.model.domain.Flair;

import java.util.List;

@Repository
public interface FlairRepository extends JpaRepository<Flair, Long> {

    List<Flair> findAllByPatientId(Long id);
}
