package src.main.java.reddit.clone.model.dto;

import src.main.java.reddit.clone.model.domain.Flair;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.List;

public class CommunityDTO {


    private String name;
    private String description;
    private String creationDate;
    private boolean isSuspended;
    private String suspendedReason;


    private List<FlairDTO> flairs;
    public List<FlairDTO> getFlairs() {
        return flairs;
    }

    public void setFlairs(List<FlairDTO> flairs) {
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