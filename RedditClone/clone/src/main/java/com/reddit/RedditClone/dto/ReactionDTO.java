package com.reddit.RedditClone.dto;

import com.reddit.RedditClone.model.Reaction;
import com.reddit.RedditClone.model.ReactionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReactionDTO {
    private ReactionType type;
    private LocalDate timestamp;

    private Long postId;

    private UserDTO user;

    private PostDTO post;

    private CommentDTO comment;
    public ReactionDTO(Reaction reaction) {
        type = reaction.getType();
    }
}
