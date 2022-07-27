package src.main.java.reddit.clone.model.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Flair extends BaseEntity{

    private String name;
    @ManyToOne
    private Post post;

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
