package reddit.clone.Services;


import reddit.clone.model.domain.User;
import reddit.clone.model.dto.UserDTO;

public interface UserService {

    User add(UserDTO dto);

    User getAll();
    User getOne(long id);

    User update(long id);

    User delete(long id);

}
