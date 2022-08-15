package reddit.clone.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import reddit.clone.model.domain.Rule;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RuleRepository extends JpaRepository<Rule, Long> {

    List<Rule> findAllById(Long id);
}
