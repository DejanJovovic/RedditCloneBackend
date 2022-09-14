package com.reddit.RedditClone.dto;

import com.reddit.RedditClone.model.Comment;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

public class CommentDTO {

    private Long id;

    private String text;
    private LocalDate creationDate;

    private PostDTO post;



    public CommentDTO(Comment comment) {
        id = comment.getCommentId();
        text = comment.getText();
        post = new PostDTO(comment.getPost());
    }





    public PostDTO getPost() {
        return post;
    }

    public void setPostDTO(PostDTO post) {
        this.post = post;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public CommentDTO() {}

}
