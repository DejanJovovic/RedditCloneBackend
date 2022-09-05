package com.reddit.RedditClone.dto;

import com.reddit.RedditClone.model.Community;

import java.time.LocalDate;
import java.util.List;


public class CommunityDTO {
    private Long id;
    private String name;

    private String description;


    private LocalDate creationDate;
    private boolean isSuspended;
    private String suspendedReason;


    public CommunityDTO(){

    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public boolean isSuspended() {
        return isSuspended;
    }


    private List<FlairDTO> flairs;

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


    public void setSuspended(boolean suspended) {
        isSuspended = suspended;
    }

    public String getSuspendedReason() {
        return suspendedReason;
    }

    public void setSuspendedReason(String suspendedReason) {
        this.suspendedReason = suspendedReason;
    }

    public List<FlairDTO> getFlairs() {
        return flairs;
    }

    public void setFlairs(List<FlairDTO> flairs) {
        this.flairs = flairs;
    }


    public CommunityDTO(Community community) {
        this(community.getId(), community.getName(), community.getDescription());
    }

    public CommunityDTO(Long id, String name, String description) {
        super();
        this.id = id;
        this.name = name;
        this.description = description;

    }
}

