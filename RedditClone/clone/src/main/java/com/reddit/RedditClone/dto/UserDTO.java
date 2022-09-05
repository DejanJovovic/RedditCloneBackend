package com.reddit.RedditClone.dto;


import com.reddit.RedditClone.model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO {

    private Long id;

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    private String email;
    private String avatar;
    private LocalDate creationDate;

    private String description;
    private String displayName;

    private CommunityDTO community;

    public UserDTO(User createdUser) {
        this.id = createdUser.getId();
        this.username = createdUser.getUsername();
    }
}
