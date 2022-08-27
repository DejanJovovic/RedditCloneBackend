package reddit.clone.model.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Community extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private String creationDate;
    private String suspendedReason;
    private boolean isSuspended;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private User user;



    public void addPost(Post post) {
        posts.add(post);
        post.setCommunity(this);
    }

    public Community() {

    }

    @OneToMany(mappedBy = "community", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Post> posts = new HashSet<>();


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public boolean isSuspended() {
        return isSuspended;
    }

    public void setSuspended(boolean suspended) {
        isSuspended = suspended;
    }

    public String getSuspendedReason() {
        return suspendedReason;
    }

    public void setSuspendedReason(String suspendedReason) {
        this.suspendedReason = suspendedReason;
    }

}
