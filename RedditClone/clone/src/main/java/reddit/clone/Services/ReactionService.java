package reddit.clone.Services;


import reddit.clone.model.domain.Post;
import reddit.clone.model.domain.Reaction;
import reddit.clone.model.domain.User;
import reddit.clone.model.dto.PostDTO;
import reddit.clone.model.dto.ReactionDTO;

import java.util.List;

public interface ReactionService {

    Reaction update(long id, ReactionDTO dto);

    Reaction add(ReactionDTO dto);

    List<Reaction> getAll();
    Reaction getOne(long id);

    Reaction delete(long id);

}
