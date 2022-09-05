package com.reddit.RedditClone.repository;

import com.reddit.RedditClone.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findAllById(Long id);
}
