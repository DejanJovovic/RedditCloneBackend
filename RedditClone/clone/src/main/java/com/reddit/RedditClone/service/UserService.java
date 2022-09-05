package com.reddit.RedditClone.service;




import com.reddit.RedditClone.dto.UserDTO;
import com.reddit.RedditClone.model.User;

import java.util.List;

public interface UserService {

    User add(UserDTO dto);

    List<User> getAll();
    User getOne(Long id);

    User update(Long id, UserDTO dto);

    User delete(Long id);

    User createUser(UserDTO userDTO);

    User findByUsername(String username);

}
