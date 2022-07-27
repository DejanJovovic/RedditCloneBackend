package src.main.java.reddit.clone.model.dto;

import src.main.java.reddit.clone.model.domain.Comment;
import src.main.java.reddit.clone.model.domain.Post;
import src.main.java.reddit.clone.model.domain.Report;
import src.main.java.reddit.clone.model.domain.User;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

public class ReportDTO {

    private Report reason;
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

    public Report getReason() {
        return reason;
    }

    public void setReason(Report reason) {
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

