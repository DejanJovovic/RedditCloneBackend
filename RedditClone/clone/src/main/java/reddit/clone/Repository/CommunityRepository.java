package reddit.clone.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import src.main.java.reddit.clone.model.domain.Community;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommunityRepository extends JpaRepository<Community, Long> {

    List<Community> findAllByPatientId(Long id);
}
