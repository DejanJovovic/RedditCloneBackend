package reddit.clone.model.dto;

import reddit.clone.model.domain.Community;
import reddit.clone.model.domain.Post;
import reddit.clone.model.domain.User;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

public class PostDTO {

    private Long id;

    private String title;
    private String text;
    private LocalDate creationDate;
    private String imagePath;

    public Integer karma;

    private UserDTO user;
    private CommunityDTO community;


    public PostDTO() {

    }

    public PostDTO(Post post) {
        id = post.getPostId();
        title = post.getTitle();
        text = post.getText();
        karma = post.getKarma();
        imagePath = post.getImagePath();
        community = new CommunityDTO(post.getCommunity());
    }



    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public CommunityDTO getCommunity() {
        return community;
    }

    public void setCommunity(CommunityDTO community) {
        this.community = community;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getKarma() {
        return karma;
    }

    public void setKarma(Integer karma) {
        this.karma = karma;
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
