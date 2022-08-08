package reddit.clone.Services;


import reddit.clone.model.domain.Report;
import reddit.clone.model.dto.ReportDTO;

import java.util.List;

public interface ReportService {

    Report add(ReportDTO dto);

    List<Report> getAll();
    Report getOne(long id);

    Report update(long id, ReportDTO dto);

    Report delete(long id);

}
