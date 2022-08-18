package reddit.clone.Services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reddit.clone.Repository.UserRepository;
import reddit.clone.Services.UserService;
import reddit.clone.model.domain.User;
import reddit.clone.model.dto.UserDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public User register(UserDTO userDTO) {

        User user = userRepository.getByEmail(userDTO.getEmail());

        if(user != null) {
            return null;
        }
        user = new User();
        user.setEmail(userDTO.getEmail());
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());

        return userRepository.save(user);
    }

    @Override
    public User add(UserDTO dto) {
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());
        user.setEmail(dto.getEmail());
        user.setAvatar(dto.getAvatar());
        user.setRegistrationDate(dto.getRegistrationDate());
        user.setDescription(dto.getDescription());
        user.setDisplayName(dto.getDisplayName());
        userRepository.save(user);
        return user;
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getOne(long id) {

        Optional<User> user = userRepository.findById(id);

        if(user.isEmpty()) {
            return null;
        }

        return user.get();
    }

    @Override
    public User update(long id, UserDTO dto) {
        Optional<User> user = userRepository.findById(id);

        if(user.isEmpty()) {
            return null;
        }
        user.get().setUsername(dto.getUsername());
        user.get().setPassword(dto.getPassword());
        user.get().setEmail(dto.getEmail());
        user.get().setAvatar(dto.getAvatar());
        user.get().setRegistrationDate(dto.getRegistrationDate());
        user.get().setDescription(dto.getDescription());
        user.get().setDisplayName(dto.getDisplayName());
        return userRepository.save(user.get());
    }

    @Override
    public User delete(long id) {

        Optional<User> user = userRepository.findById(id);

        if(user.isEmpty()) {
            return null;
        }

        user.get().setDeleted(true);

        return userRepository.save(user.get());
    }


}
