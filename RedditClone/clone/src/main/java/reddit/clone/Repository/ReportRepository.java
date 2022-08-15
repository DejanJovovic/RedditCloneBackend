package reddit.clone.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import reddit.clone.model.domain.Report;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {

    List<Report> findAllById(Long id);
}
