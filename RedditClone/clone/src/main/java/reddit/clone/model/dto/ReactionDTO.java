package reddit.clone.model.dto;

import reddit.clone.model.domain.Comment;
import reddit.clone.model.domain.Post;
import reddit.clone.model.domain.Reaction;
import reddit.clone.model.domain.User;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

public class ReactionDTO {


    private Reaction type;
    private LocalDate timestamp;


    private UserDTO user;

    private PostDTO post;



    private CommentDTO comment;

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


    public Reaction getType() {
        return type;
    }

    public void setType(Reaction type) {
        this.type = type;
    }

    public LocalDate getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDate timestamp) {
        this.timestamp = timestamp;
    }

}
