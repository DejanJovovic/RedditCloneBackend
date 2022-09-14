//package com.reddit.RedditClone.service.Impl;
//
//import com.reddit.RedditClone.dto.CommentDTO;
//import com.reddit.RedditClone.model.Comment;
//import com.reddit.RedditClone.repository.CommentRepository;
//import com.reddit.RedditClone.service.CommentService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//
//import java.util.List;
//import java.util.Optional;
//
//@Component
//public class CommentServiceImpl implements CommentService {
//
//    @Autowired
//    private CommentRepository commentRepository;
//
//    @Override
//    public Comment add(CommentDTO dto) {
//
//        Comment comment = new Comment();
//        comment.setText(dto.getText());
//        comment.setTimestamp(dto.getTimestamp());
//        comment.setDeleted(dto.isDeleted());
//        commentRepository.save(comment);
//        return comment;
//    }
//
//    @Override
//    public List<Comment> getAll() {
//
//        return commentRepository.findAll();
//    }
//
//    @Override
//    public Comment getOne(Long id) {
//        Optional<Comment> comment = commentRepository.findById(id);
//
//        if(comment.isEmpty()) {
//            return null;
//        }
//
//        return comment.get();
//    }
//
//    @Override
//    public Comment update(Long id, CommentDTO dto) {
//        Optional<Comment> comment = commentRepository.findById(id);
//
//        if(comment.isEmpty()) {
//            return null;
//        }
//        comment.get().setText(dto.getText());
//        comment.get().setTimestamp(dto.getTimestamp());
//        comment.get().setDeleted(dto.isDeleted());
//        return commentRepository.save(comment.get());
//    }
//
//    @Override
//    public Comment delete(Long id) {
//        Optional<Comment> comment = commentRepository.findById(id);
//
//        if(comment.isEmpty()) {
//            return null;
//        }
//        comment.get().setDeleted(true);
//        return commentRepository.save(comment.get());
//    }
//}
