package com.reddit.RedditClone.repository;

import com.reddit.RedditClone.model.Reaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface ReactionRepository extends JpaRepository<Reaction, Long> {

    List<Reaction> findAllById(Long id);

    @Query("select r from Reaction r where r.post.postId=?1 and r.user.Id=?2")
    public Reaction findByUserId(Long postId, Long id);
}
