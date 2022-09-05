package com.reddit.RedditClone.controller;

import com.reddit.RedditClone.dto.PostDTO;
import com.reddit.RedditClone.model.Community;
import com.reddit.RedditClone.model.Post;
import com.reddit.RedditClone.model.User;
import com.reddit.RedditClone.service.CommunityService;
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
@RequestMapping(value = "api/posts")
public class PostController {

    @Autowired
    private PostService postService;
    @Autowired
    private UserService userService;

    @Autowired
    private CommunityService communityService;

    @PostMapping(consumes = "application/json")
    public ResponseEntity<PostDTO>createPost(@RequestBody PostDTO postDTO){
        if(postDTO.getCommunity() == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Community community = communityService.findOneById(postDTO.getCommunity().getId());

        if(community == null){
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        Post post = new Post();
        post.setTitle(postDTO.getTitle());
        post.setText(postDTO.getText());
        post.setImagePath(postDTO.getImagePath());
        LocalDate lt = LocalDate.now();
        post.setCreationDate(lt);
        post.setCommunity(community);
        User user = userService.findByUsername("jova");
        post.setUser(user);
        community.addPost(post);

        post = postService.save(post);
        return new ResponseEntity<>(new PostDTO(post), HttpStatus.CREATED);
    }
    @GetMapping(value = "/all")
    public ResponseEntity<List<PostDTO>> getAllPosts(){
        List<Post> posts = postService.findAll();

        List<PostDTO> postDTOS = new ArrayList<>();
        for (Post p : posts){
            postDTOS.add(new PostDTO(p));
        }
        return new ResponseEntity<>(postDTOS,HttpStatus.OK);
    }

    @GetMapping(value = "/communityPosts/{id}")
    public ResponseEntity<List<PostDTO>> getCommunityPosts(@PathVariable Long id){
        List<Post> posts = postService.findAllByCommunity(id);

        List<PostDTO> postDTOS = new ArrayList<>();
        for (Post p : posts){
            postDTOS.add(new PostDTO(p));
        }
        return new ResponseEntity<>(postDTOS,HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id){
        Post post = postService.findOneById(id);
        if(post != null) {
            postService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<PostDTO>getPost(@PathVariable Long id){
        Post post = postService.findOneById(id);
        if (post == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new PostDTO(post), HttpStatus.OK);

    }

    @PutMapping(value = "/edit/{id}")
    public ResponseEntity<PostDTO> updatePost(@PathVariable Long id,@RequestBody PostDTO postDTO){

        Post post = postService.findOneById(id);
        if(post == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        post.setTitle(postDTO.getTitle());
        post.setText(postDTO.getText());

        post = postService.save(post);
        return new ResponseEntity<>(new PostDTO(post),HttpStatus.OK);
    }
}
