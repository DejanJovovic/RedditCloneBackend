package reddit.clone.model.dto;

import reddit.clone.model.domain.Comment;
import reddit.clone.model.domain.Post;
import reddit.clone.model.domain.Report;
import reddit.clone.model.domain.User;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

public class ReportDTO {

    private String reason;
    private LocalDate timestamp;
    private User byUser;
    private boolean accepted;



    private CommentDTO comment;


    private PostDTO post;

    public CommentDTO getComment() {
        return comment;
    }

    public void setComment(CommentDTO comment) {
        this.comment = comment;
    }

    public PostDTO getPost() {
        return post;
    }

    public void setPost(PostDTO post) {
        this.post = post;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public LocalDate getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDate timestamp) {
        this.timestamp = timestamp;
    }

    public User getByUser() {
        return byUser;
    }

    public void setByUser(User byUser) {
        this.byUser = byUser;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }

}

