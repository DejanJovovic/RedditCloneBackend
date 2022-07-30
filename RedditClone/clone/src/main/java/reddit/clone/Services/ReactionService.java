package reddit.clone.Services;


import reddit.clone.model.domain.Reaction;
import reddit.clone.model.dto.ReactionDTO;

public interface ReactionService {

    Reaction update(ReactionDTO dto);
}
