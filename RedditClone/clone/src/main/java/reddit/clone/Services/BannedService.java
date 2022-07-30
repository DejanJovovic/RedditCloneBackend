package reddit.clone.Services;

import reddit.clone.model.domain.Banned;
import reddit.clone.model.dto.BannedDTO;

public interface BannedService {

    Banned update(long id);
}
