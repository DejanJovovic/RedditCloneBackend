package src.main.java.reddit.clone.model.domain;

import src.main.java.reddit.clone.model.domain.BaseEntity;
import src.main.java.reddit.clone.model.domain.User;

import java.time.LocalDate;
import javax.persistence.*;

@Entity
public class Post extends BaseEntity {
    private String title;
    private String text;
    private LocalDate creationDate;
    private String imagePath;

    @ManyToOne
    private User user;
    @ManyToOne
    private Community community;

    public Community getCommunity() {
        return community;
    }

    public void setCommunity(Community community) {
        this.community = community;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

}
