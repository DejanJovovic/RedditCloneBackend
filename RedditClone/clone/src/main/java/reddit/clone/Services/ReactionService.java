package reddit.clone.Services;


import reddit.clone.model.domain.Post;
import reddit.clone.model.domain.Reaction;
import reddit.clone.model.domain.User;
import reddit.clone.model.dto.PostDTO;
import reddit.clone.model.dto.ReactionDTO;

import java.util.List;

public interface ReactionService {

    Reaction update(Long id, ReactionDTO dto);

    Reaction add(ReactionDTO dto);

    List<Reaction> getAll();
    Reaction getOne(Long id);

    Reaction delete(Long id);

    Reaction save(Reaction reaction);

    Reaction findUserById(Long postId, Long id);
}
