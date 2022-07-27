package reddit.clone.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import src.main.java.reddit.clone.model.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findAllByPatientId(Long id);
}
