package reddit.clone.Services;

import reddit.clone.model.domain.Flair;
import reddit.clone.model.domain.User;
import reddit.clone.model.dto.FlairDTO;
import reddit.clone.model.dto.UserDTO;

public interface FlairService {



    Flair add(FlairDTO dto);

    Flair getAll();
    Flair getOne(long id);

    Flair update(long id);
}
