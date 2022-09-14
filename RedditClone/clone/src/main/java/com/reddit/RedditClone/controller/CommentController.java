package com.reddit.RedditClone.controller;

import com.reddit.RedditClone.dto.CommentDTO;
import com.reddit.RedditClone.dto.PostDTO;
import com.reddit.RedditClone.model.Comment;
import com.reddit.RedditClone.model.Community;
import com.reddit.RedditClone.model.Post;
import com.reddit.RedditClone.model.User;
import com.reddit.RedditClone.service.CommentService;
import com.reddit.RedditClone.service.PostService;
import com.reddit.RedditClone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("api/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private UserService userService;

    @Autowired
    private PostService postService;



    @PostMapping(consumes = "application/json")
    public ResponseEntity<CommentDTO>createComment(@RequestBody CommentDTO commentDTO){
        if(commentDTO.getPost() == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Post post = postService.findOneById(commentDTO.getPost().getId());

        if(post == null){
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        Comment comment = new Comment();
        comment.setText(commentDTO.getText());
        LocalDate lt = LocalDate.now();
        comment.setCreationDate(lt);
        comment.setPost(post);
        User user = userService.findByUsername("dejan");
        comment.setUser(user);
        post.addComment(comment);

        comment = commentService.save(comment);
        return new ResponseEntity<>(new CommentDTO(comment), HttpStatus.CREATED);
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<CommentDTO>> getAllComments(){
        List<Comment> comments = commentService.findAll();

        List<CommentDTO> commentDTOS = new ArrayList<>();
        for (Comment c : comments){
            commentDTOS.add(new CommentDTO(c));
        }
        return new ResponseEntity<>(commentDTOS,HttpStatus.OK);
    }

    @GetMapping(value = "/postComments/{id}")
    public ResponseEntity<List<CommentDTO>> getPostComments(@PathVariable Long id){
        List<Comment> comments = commentService.findAllByPost(id);

        List<CommentDTO> commentDTOS = new ArrayList<>();
        for (Comment c : comments){
            commentDTOS.add(new CommentDTO(c));
        }
        return new ResponseEntity<>(commentDTOS,HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long id){
        Comment comment = commentService.findOneById(id);
        if(comment != null) {
            commentService.remove(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CommentDTO>getComment(@PathVariable Long id){
        Comment comment = commentService.findOneById(id);
        if (comment == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new CommentDTO(comment), HttpStatus.OK);

    }

    @PutMapping(value = "/edit/{id}")
    public ResponseEntity<CommentDTO> updateComment(@PathVariable Long id
            ,@RequestBody CommentDTO commentDTO){

        Comment comment = commentService.findOneById(id);
        if(comment == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        comment.setText(commentDTO.getText());

        comment = commentService.save(comment);
        return new ResponseEntity<>(new CommentDTO(comment),HttpStatus.OK);
    }
}

