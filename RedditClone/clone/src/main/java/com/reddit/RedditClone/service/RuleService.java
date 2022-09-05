package com.reddit.RedditClone.service;


import com.reddit.RedditClone.dto.RuleDTO;
import com.reddit.RedditClone.model.Rule;

import java.util.List;

public interface RuleService {

    Rule add(RuleDTO dto);

    List<Rule> getAll();

    Rule getOne(Long id);

    Rule update(Long id, RuleDTO dto);


    Rule delete(Long id);

}