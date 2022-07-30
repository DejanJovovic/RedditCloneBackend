package reddit.clone.Services;


import reddit.clone.model.domain.Report;
import reddit.clone.model.dto.ReportDTO;

public interface ReportService {

    Report add(ReportDTO dto);

    Report getAll();
    Report getOne(long id);

    Report update(long id);

    Report delete(long id);

}
