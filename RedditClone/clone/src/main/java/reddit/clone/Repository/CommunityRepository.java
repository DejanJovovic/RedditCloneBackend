package reddit.clone.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import reddit.clone.model.domain.Community;

import java.util.List;

@Repository
public interface CommunityRepository extends JpaRepository<Community, Long> {

    List<Community> findAllById(Long id);

    @Query("select c from communities c where c.id =?1")
    Community findOneById(Long communityId);
}
