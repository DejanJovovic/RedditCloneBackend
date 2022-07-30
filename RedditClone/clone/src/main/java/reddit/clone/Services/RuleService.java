package reddit.clone.Services;

import reddit.clone.model.domain.Report;
import reddit.clone.model.domain.Rule;
import reddit.clone.model.dto.ReportDTO;
import reddit.clone.model.dto.RuleDTO;

public interface RuleService {

    Rule add(RuleDTO dto);

    Rule delete(long id);

}
