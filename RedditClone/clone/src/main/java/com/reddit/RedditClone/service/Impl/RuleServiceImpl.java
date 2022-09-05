package com.reddit.RedditClone.service.Impl;

import com.reddit.RedditClone.dto.RuleDTO;
import com.reddit.RedditClone.model.Rule;
import com.reddit.RedditClone.repository.RuleRepository;
import com.reddit.RedditClone.service.RuleService;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.Optional;

@Component
public class RuleServiceImpl implements RuleService {

    private RuleRepository ruleRepository;


    @Override
    public Rule add(RuleDTO dto) {
        Rule rule = new Rule();
        rule.setDescription(dto.getDescription());
        ruleRepository.save(rule);
        return rule;
    }

    @Override
    public List<Rule> getAll() {
        return ruleRepository.findAll();
    }

    @Override
    public Rule getOne(Long id) {
        Optional<Rule> rule = ruleRepository.findById(id);

        if(rule.isEmpty()) {
            return null;
        }
        return rule.get();
    }

    @Override
    public Rule update(Long id, RuleDTO dto) {
        Optional<Rule> rule = ruleRepository.findById(id);

        if(rule.isEmpty()) {
            return null;
        }
        rule.get().setDescription(dto.getDescription());
        return ruleRepository.save(rule.get());
    }


    @Override
    public Rule delete(Long id) {
        Optional<Rule> rule = ruleRepository.findById(id);

        if(rule.isEmpty()) {
            return null;
        }
        rule.get().setDeleted(true);

        return ruleRepository.save(rule.get());
    }
}
