package com.reddit.RedditClone.service;

import com.reddit.RedditClone.dto.FlairDTO;
import com.reddit.RedditClone.model.Flair;

import java.util.List;

public interface FlairService {



    Flair add(FlairDTO dto);

    List<Flair> getAll();
    Flair getOne(Long id);

    Flair update(Long id, FlairDTO dto);

    Flair delete(Long id);

}