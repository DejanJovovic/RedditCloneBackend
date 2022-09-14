package com.reddit.RedditClone.service;

import com.reddit.RedditClone.model.Comment;
import com.reddit.RedditClone.model.Post;
import com.reddit.RedditClone.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {


    @Autowired
    private CommentRepository commentRepository;


    public Comment save(Comment comment){
        return commentRepository.save(comment);
    }

    public List<Comment> findAll(){
        return commentRepository.findAll();
    }
    public Comment findOneById(Long commentId) {
        return  commentRepository.findOneById(commentId);
    }

    public void remove(Long id) {
        commentRepository.deleteById(id);
    }

    public List<Comment> findAllByPost(Long id) {
        return commentRepository.findAllByPost(id);
    }
}
