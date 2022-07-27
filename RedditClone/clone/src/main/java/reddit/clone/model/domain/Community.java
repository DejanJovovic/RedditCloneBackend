package src.main.java.reddit.clone.model.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class Community extends BaseEntity{
    private String name;
    private String description;
    private String creationDate;
    private boolean isSuspended;
    private String suspendedReason;

    @ManyToMany
    private List<Flair> flairs;

    public List<Flair> getFlairs() {
        return flairs;
    }

    public void setFlairs(List<Flair> flairs) {
        this.flairs = flairs;
    }


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
