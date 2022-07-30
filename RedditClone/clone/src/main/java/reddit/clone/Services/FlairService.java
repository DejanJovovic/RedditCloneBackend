package reddit.clone.Services;

import reddit.clone.model.domain.Flair;
import reddit.clone.model.dto.FlairDTO;

public interface FlairService {

    Flair update(FlairDTO dto);
}
