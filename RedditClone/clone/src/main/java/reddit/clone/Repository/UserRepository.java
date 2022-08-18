package reddit.clone.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import reddit.clone.model.domain.EUser;
import reddit.clone.model.domain.User;
import org.springframework.stereotype.Repository;

import javax.management.relation.Role;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findAllById(Long id);

    Optional<User> findOneByUsername(String username);

    User getByEmail(String email);

    List<User> findAllByRole(EUser role);
}
