package com.reddit.RedditClone.service;



import com.reddit.RedditClone.dto.CommunityDTO;
import com.reddit.RedditClone.model.Community;

import java.util.List;

public interface CommunityService {

    Community add(CommunityDTO dto);

    List<Community> getAll();
    Community getOne(Long id);

    Community update(Long id, CommunityDTO dto);

    Community delete(Long id);

    Community save(Community community);

    Community findOneById(Long id);



}
