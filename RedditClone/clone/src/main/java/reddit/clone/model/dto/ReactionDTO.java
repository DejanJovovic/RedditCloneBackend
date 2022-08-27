package reddit.clone.model.dto;

import reddit.clone.model.domain.*;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

public class ReactionDTO {


    private Long postId;
    private EReactionType type;
    private LocalDate timestamp;

    private UserDTO user;

    private PostDTO post;


    public ReactionDTO(Reaction reaction) {
        type = reaction.getType();
    }


    private CommentDTO comment;

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }


    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public PostDTO getPost() {
        return post;
    }

    public void setPost(PostDTO post) {
        this.post = post;
    }

    public CommentDTO getComment() {
        return comment;
    }

    public void setComment(CommentDTO comment) {
        this.comment = comment;
    }


    public EReactionType getType() {
        return type;
    }

    public void setType(EReactionType type) {
        this.type = type;
    }

    public LocalDate getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDate timestamp) {
        this.timestamp = timestamp;
    }

}
