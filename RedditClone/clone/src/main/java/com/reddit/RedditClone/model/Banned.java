package com.reddit.RedditClone.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
@Entity
public class Banned extends BaseEntity {
    private LocalDate timestamp;

    @ManyToOne
    private Community community;

    public LocalDate getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDate timestamp) {
        this.timestamp = timestamp;
    }

    public Community getCommunity() {
        return community;
    }

    public void setCommunity(Community community) {
        this.community = community;
    }


}
