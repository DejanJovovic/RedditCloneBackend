package reddit.clone.Services;

import reddit.clone.model.domain.Banned;
import reddit.clone.model.domain.Flair;
import reddit.clone.model.domain.User;
import reddit.clone.model.dto.BannedDTO;
import reddit.clone.model.dto.FlairDTO;

import java.util.List;

public interface BannedService {

    Banned add(BannedDTO dto);
    Banned update(long id, BannedDTO dto);

    List<Banned> getAll();
    Banned getOne(long id);

    Banned delete(long id);


}
