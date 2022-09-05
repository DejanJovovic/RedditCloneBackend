package com.reddit.RedditClone.service;




import com.reddit.RedditClone.dto.ReactionDTO;
import com.reddit.RedditClone.model.Reaction;

import java.util.List;

public interface ReactionService {

    Reaction update(Long id, ReactionDTO dto);

    Reaction add(ReactionDTO dto);

    List<Reaction> getAll();
    Reaction getOne(Long id);

    Reaction delete(Long id);

    Reaction save(Reaction reaction);

    Reaction findByUserId(Long postId, Long id);
}
