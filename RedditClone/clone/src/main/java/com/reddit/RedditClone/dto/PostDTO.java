package com.reddit.RedditClone.dto;
import com.reddit.RedditClone.model.Post;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;



public class PostDTO {
    private Long id;
    private String title;
    private String text;
    private String imagePath;
    private Integer karma;
    private MultipartFile file;
    private CommunityDTO community;

    public PostDTO() {
    }

    public PostDTO(Long postId) {
        this.id = postId;
    }

    public Integer getKarma() {
        return karma;
    }

    public void setKarma(Integer karma) {
        this.karma = karma;
    }

    public PostDTO(Post post){
        id = post.getPostId();
        title = post.getTitle();
        text = post.getText();
        karma = post.getKarma();
        imagePath = post.getImagePath();
        community = new CommunityDTO(post.getCommunity());

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public CommunityDTO getCommunity() {
        return community;
    }

    public void setCommunity(CommunityDTO community) {
        this.community = community;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}

