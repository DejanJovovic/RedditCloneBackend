package reddit.clone.model.domain;

import lombok.Data;
import reddit.clone.model.domain.BaseEntity;
import reddit.clone.model.domain.User;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
@Data
public class Post extends BaseEntity {

    private Long postId;
    private String title;

    private String text;
    private LocalDate creationDate;
    private String imagePath;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private User user;

    private Integer karma = 0;

    public Post() {

    }


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "communityId")
    private Community community;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private Set<Reaction> reactions = new HashSet<>();

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


    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
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

    public Integer getKarma() {
        return karma;
    }

    public void setKarma(Integer karma) {
        this.karma = karma;
    }

}
