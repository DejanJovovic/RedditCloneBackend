package com.reddit.RedditClone.service.Impl;

import com.reddit.RedditClone.dto.UserDTO;
import com.reddit.RedditClone.model.User;
import com.reddit.RedditClone.repository.UserRepository;
import com.reddit.RedditClone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    private PasswordEncoder passwordEncoder;


    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public User add(UserDTO dto) {
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());
        user.setEmail(dto.getEmail());
        user.setAvatar(dto.getAvatar());
        user.setCreationDate(dto.getCreationDate());
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
    public User getOne(Long id) {

        Optional<User> user = userRepository.findById(id);

        if(user.isEmpty()) {
            return null;
        }

        return user.get();
    }

    @Override
    public User update(Long id, UserDTO dto) {
        Optional<User> user = userRepository.findById(id);

        if(user.isEmpty()) {
            return null;
        }
        user.get().setUsername(dto.getUsername());
        user.get().setPassword(dto.getPassword());
        user.get().setEmail(dto.getEmail());
        user.get().setAvatar(dto.getAvatar());
        user.get().setCreationDate(dto.getCreationDate());
        user.get().setDescription(dto.getDescription());
        user.get().setDisplayName(dto.getDisplayName());
        return userRepository.save(user.get());
    }

    @Override
    public User delete(Long id) {

        Optional<User> user = userRepository.findById(id);

        if(user.isEmpty()) {
            return null;
        }

        user.get().setDeleted(true);

        return userRepository.save(user.get());
    }

    @Override
    public User createUser(UserDTO userDTO) {
        Optional<User> user = userRepository.findFirstByUsername(userDTO.getUsername());

        if(user.isPresent()) {
            return null;
        }

        User newUser = new User();
        newUser.setUsername(userDTO.getUsername());
        newUser.setPassword(userDTO.getPassword());
        newUser = userRepository.save(newUser);

        return newUser;
    }

    @Override
    public User findByUsername(String username) {
        Optional<User> user = userRepository.findFirstByUsername(username);

        if(!user.isEmpty()) {
            return user.get();
        }
        return null;
    }

}
