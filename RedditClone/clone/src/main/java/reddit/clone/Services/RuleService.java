package reddit.clone.Services;

import reddit.clone.model.domain.Report;
import reddit.clone.model.domain.Rule;
import reddit.clone.model.domain.User;
import reddit.clone.model.dto.ReportDTO;
import reddit.clone.model.dto.RuleDTO;

import java.util.List;

public interface RuleService {

    Rule add(RuleDTO dto);

    List<Rule> getAll();

    Rule getOne(long id);

    Rule update(long id, RuleDTO dto);


    Rule delete(long id);

}
