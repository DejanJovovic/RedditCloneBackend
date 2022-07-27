package src.main.java.reddit.clone.model.dto;

import src.main.java.reddit.clone.model.domain.Community;


import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

public class BannedDTO {

    private LocalDate timestamp;


    private CommunityDTO community;



    public LocalDate getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDate timestamp) {
        this.timestamp = timestamp;
    }

}
