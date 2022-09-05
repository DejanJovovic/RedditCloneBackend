package com.reddit.RedditClone.service.Impl;

import com.reddit.RedditClone.dto.ReportDTO;
import com.reddit.RedditClone.model.Report;
import com.reddit.RedditClone.repository.ReportRepository;
import com.reddit.RedditClone.service.ReportService;
import org.springframework.stereotype.Component;


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
    public Report getOne(Long id) {
        Optional<Report> report = reportRepository.findById(id);

        if(report.isEmpty()) {
            return null;
        }

        return report.get();
    }

    @Override
    public Report update(Long id, ReportDTO dto) {
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
    public Report delete(Long id) {
        Optional<Report> report = reportRepository.findById(id);

        if(report.isEmpty()) {
            return null;
        }
        report.get().setDeleted(true);
        return reportRepository.save(report.get());
    }
}
