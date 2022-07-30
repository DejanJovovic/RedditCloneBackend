package reddit.clone.Services;

import reddit.clone.model.domain.Community;
import reddit.clone.model.dto.CommunityDTO;

public interface CommunityService {

    Community add(CommunityDTO dto);

    Community getAll();
    Community getOne(long id);

    Community update(long id);

    Community delete(long id);

}
