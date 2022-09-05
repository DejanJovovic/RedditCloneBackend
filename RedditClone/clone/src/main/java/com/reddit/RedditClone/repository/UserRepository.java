package com.reddit.RedditClone.repository;

import java.util.List;
import java.util.Optional;

import com.reddit.RedditClone.model.EUser;
import com.reddit.RedditClone.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


    List<User> findAllById(Long id);
    User getByEmail(String email);
    List<User> findAllByRole(EUser role);
    Optional<User> findOneByUsername(String username);
    Optional<User> findFirstByUsername(String username);

}
