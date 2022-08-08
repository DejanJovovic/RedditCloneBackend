package reddit.clone.Services.Impl;

import org.springframework.stereotype.Component;
import reddit.clone.Repository.RuleRepository;
import reddit.clone.Services.RuleService;
import reddit.clone.model.domain.Rule;
import reddit.clone.model.dto.RuleDTO;
import reddit.clone.model.dto.UserDTO;

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
    public Rule getOne(long id) {
        Optional<Rule> rule = ruleRepository.findById(id);

        if(rule.isEmpty()) {
            return null;
        }
        return rule.get();
    }

    @Override
    public Rule update(long id, RuleDTO dto) {
        Optional<Rule> rule = ruleRepository.findById(id);

        if(rule.isEmpty()) {
            return null;
        }
        rule.get().setDescription(dto.getDescription());
        return ruleRepository.save(rule.get());
    }


    @Override
    public Rule delete(long id) {
        Optional<Rule> rule = ruleRepository.findById(id);

        if(rule.isEmpty()) {
            return null;
        }
        rule.get().setDeleted(true);

        return ruleRepository.save(rule.get());
    }
}
