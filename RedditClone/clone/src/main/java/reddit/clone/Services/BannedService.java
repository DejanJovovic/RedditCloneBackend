package reddit.clone.Services;

import reddit.clone.model.domain.Banned;
import reddit.clone.model.domain.Flair;
import reddit.clone.model.dto.BannedDTO;
import reddit.clone.model.dto.FlairDTO;

public interface BannedService {

    Banned add(BannedDTO dto);
    Banned update(long id);

    Banned getAll();
    Banned getOne(long id);
}
