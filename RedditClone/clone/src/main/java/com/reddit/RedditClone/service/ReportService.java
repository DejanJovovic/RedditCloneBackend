package com.reddit.RedditClone.service;



import com.reddit.RedditClone.dto.ReportDTO;
import com.reddit.RedditClone.model.Report;

import java.util.List;

public interface ReportService {

    Report add(ReportDTO dto);

    List<Report> getAll();
    Report getOne(Long id);

    Report update(Long id, ReportDTO dto);

    Report delete(Long id);

}
