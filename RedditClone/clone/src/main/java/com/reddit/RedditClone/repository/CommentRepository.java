package com.reddit.RedditClone.repository;

import com.reddit.RedditClone.model.Comment;
import com.reddit.RedditClone.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query("select c from Comment c where c.commentId =?1")
    Comment findOneById(Long commentId);

    @Query("select c from Comment c where c.post.id =?1")

    List<Comment> findAllByPost(Long id);
}
