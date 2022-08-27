package reddit.clone.Services;

import reddit.clone.model.domain.Community;
import reddit.clone.model.dto.CommunityDTO;

import java.util.List;

public interface CommunityService {

    Community add(CommunityDTO dto);

    List<Community> getAll();
    Community getOne(long id);

    Community update(long id, CommunityDTO dto);

    Community delete(long id);

    Community save(Community community);

}
