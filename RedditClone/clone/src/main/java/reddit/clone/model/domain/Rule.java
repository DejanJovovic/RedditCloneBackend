package reddit.clone.model.domain;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Rule extends BaseEntity{

    private String description;

    @ManyToOne
    private Community community;

    public Community getCommunity() {
        return community;
    }

    public void setCommunity(Community community) {
        this.community = community;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
