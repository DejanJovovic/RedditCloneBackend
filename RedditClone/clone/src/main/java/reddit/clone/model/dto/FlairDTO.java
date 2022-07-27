package src.main.java.reddit.clone.model.dto;

import src.main.java.reddit.clone.model.domain.Post;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

public class FlairDTO {


    private String name;

    private PostDTO post;

    public PostDTO getPost() {
        return post;
    }

    public void setPost(PostDTO post) {
        this.post = post;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
