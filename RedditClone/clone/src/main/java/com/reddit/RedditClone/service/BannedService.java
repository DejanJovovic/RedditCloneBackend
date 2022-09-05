package com.reddit.RedditClone.service;


import com.reddit.RedditClone.dto.BannedDTO;
import com.reddit.RedditClone.model.Banned;

import java.util.List;

public interface BannedService {

    Banned add(BannedDTO dto);
    Banned update(Long id, BannedDTO dto);

    List<Banned> getAll();
    Banned getOne(Long id);

    Banned delete(Long id);


}
