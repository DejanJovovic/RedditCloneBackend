package reddit.clone.Services;


import reddit.clone.model.domain.User;
import reddit.clone.model.dto.UserDTO;

import java.util.ArrayList;
import java.util.List;

public interface UserService {

    User register(UserDTO userDTO);

    User add(UserDTO dto);

    List<User> getAll();
    User getOne(long id);

    User update(long id, UserDTO dto);

    User delete(long id);

    User createUser(UserDTO userDTO);

    User findByUsername(String username);

}
