package reddit.clone.Services.Impl;

import org.springframework.stereotype.Component;
import reddit.clone.Repository.ReportRepository;
import reddit.clone.Services.ReportService;
import reddit.clone.model.domain.Report;
import reddit.clone.model.dto.ReportDTO;
import reddit.clone.model.dto.UserDTO;

import java.util.List;
import java.util.Optional;

@Component
public class ReportServiceImpl implements ReportService {

    private ReportRepository reportRepository;


    @Override
    public Report add(ReportDTO dto) {
      Report report = new Report();
      report.setReason(dto.getReason());
      report.setTimestamp(dto.getTimestamp());
      report.setByUser(dto.getByUser());
      report.setAccepted(dto.isAccepted());
      reportRepository.save(report);
        return report;
    }

    @Override
    public List<Report> getAll() {
        return reportRepository.findAll();
    }

    @Override
    public Report getOne(long id) {
        Optional<Report> report = reportRepository.findById(id);

        if(report.isEmpty()) {
            return null;
        }

        return report.get();
    }

    @Override
    public Report update(long id, ReportDTO dto) {
        Optional<Report> report = reportRepository.findById(id);

        if(report.isEmpty()) {
            return null;

        }
        report.get().setReason(dto.getReason());
        report.get().setTimestamp(dto.getTimestamp());
        report.get().setByUser(dto.getByUser());
        report.get().setAccepted(dto.isAccepted());
        return reportRepository.save(report.get());
    }

    @Override
    public Report delete(long id) {
        Optional<Report> report = reportRepository.findById(id);

        if(report.isEmpty()) {
            return null;
        }
        report.get().setDeleted(true);
        return reportRepository.save(report.get());
    }
}
