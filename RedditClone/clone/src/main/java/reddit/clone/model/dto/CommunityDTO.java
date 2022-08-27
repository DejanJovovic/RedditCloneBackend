package reddit.clone.model.dto;

import reddit.clone.model.domain.Community;
import reddit.clone.model.domain.Flair;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.List;

public class CommunityDTO {


    private Long id;
    private String name;
    private String description;

    private String creationDate;
    private boolean isSuspended;
    private String suspendedReason;

    public CommunityDTO() {

    }


    private List<FlairDTO> flairs;

    public CommunityDTO(Community community) {
        this(community.getId(), community.getName(), community.getDescription());
    }

    public CommunityDTO(Long id, String name, String description) {
        super();
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public List<FlairDTO> getFlairs() {
        return flairs;
    }

    public void setFlairs(List<FlairDTO> flairs) {
        this.flairs = flairs;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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