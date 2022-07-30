package reddit.clone.Services;


import reddit.clone.model.domain.Post;
import reddit.clone.model.domain.Reaction;
import reddit.clone.model.domain.User;
import reddit.clone.model.dto.PostDTO;
import reddit.clone.model.dto.ReactionDTO;

public interface ReactionService {

    Reaction update(long id);

    Reaction add(ReactionDTO dto);

    Reaction getAll();
    Reaction getOne(long id);

    Reaction delete(long id);

}
