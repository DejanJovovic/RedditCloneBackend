package src.main.java.reddit.clone.model.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
public class Reaction extends BaseEntity {

    private Reaction type;
    private LocalDate timestamp;

    @ManyToOne
    private User user;

    @ManyToOne
    private Post post;


    @ManyToOne
    private Comment comment;

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
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
