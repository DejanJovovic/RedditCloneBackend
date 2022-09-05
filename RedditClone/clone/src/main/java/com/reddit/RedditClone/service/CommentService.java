package com.reddit.RedditClone.service;


import com.reddit.RedditClone.dto.CommentDTO;
import com.reddit.RedditClone.model.Comment;

import java.util.List;

public interface CommentService {

    Comment add(CommentDTO dto);

    List<Comment> getAll();
    Comment getOne(Long id);

    Comment update(Long id, CommentDTO dto);

    Comment delete(Long id);

}

