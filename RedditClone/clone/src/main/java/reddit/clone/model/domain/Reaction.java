package reddit.clone.model.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
public class Reaction extends BaseEntity {

    private EReactionType type;
    private LocalDate timestamp;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "postId")
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
