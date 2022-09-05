package com.reddit.RedditClone.dto;


import javax.persistence.Entity;
import javax.persistence.ManyToOne;

public class RuleDTO {


    private String description;


    private CommunityDTO community;

    public CommunityDTO getCommunity() {
        return community;
    }

    public void setCommunity(CommunityDTO community) {
        this.community = community;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
