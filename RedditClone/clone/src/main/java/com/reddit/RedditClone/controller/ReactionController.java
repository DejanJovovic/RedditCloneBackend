package com.reddit.RedditClone.controller;

import com.reddit.RedditClone.dto.ReactionDTO;
import com.reddit.RedditClone.model.Post;
import com.reddit.RedditClone.model.Reaction;
import com.reddit.RedditClone.model.User;
import com.reddit.RedditClone.service.Impl.PostServiceImpl;
import com.reddit.RedditClone.service.ReactionService;
import com.reddit.RedditClone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

import static com.reddit.RedditClone.model.ReactionType.UPVOTE;

@RestController
@RequestMapping(value = "/api/reaction")
public class ReactionController {

    @Autowired
    private ReactionService reactionService;

    @Autowired
    private UserService userService;

    @Autowired
    private PostServiceImpl postServiceImpl;

    @PostMapping(consumes = "application/json")
    public ResponseEntity<ReactionDTO>reaction(@RequestBody ReactionDTO reactionDTO){
        if(reactionDTO.getPostId() == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Post post = postServiceImpl.findOneById(reactionDTO.getPostId());
        if (post == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Long id = Long.valueOf(2);
        Reaction reac = reactionService.findByUserId(post.getPostId(),id);
        if(reac != null){
            if (reac.getType().toString() == "UPVOTE"){
                post.setKarma(post.getKarma() - 1);
            }
            if (reac.getType().toString() == "DOWNVOTE"){
                post.setKarma(post.getKarma() + 1);
            }
            if(UPVOTE.equals(reactionDTO.getType())){
                post.setKarma(post.getKarma() + 1);
            } else {

                post.setKarma(post.getKarma() - 1);
            }
            postServiceImpl.save(post);
            reac.setType(reactionDTO.getType());
            reac = reactionService.save(reac);

            return new ResponseEntity<>(new ReactionDTO(reac), HttpStatus.CREATED);
        }
        if(UPVOTE.equals(reactionDTO.getType())){
            post.setKarma(post.getKarma() + 1);
        } else {

            post.setKarma(post.getKarma() - 1);
        }
        postServiceImpl.save(post);

        User user = userService.findByUsername("mika");

        Reaction reaction = new Reaction();
        LocalDate lt = LocalDate.now();
        reaction.setTimestamp(lt);
        reaction.setType(reactionDTO.getType());
        reaction.setUser(user);
        reaction.setPost(post);
        reaction = reactionService.save(reaction);
        return new ResponseEntity<>(new ReactionDTO(reaction), HttpStatus.CREATED);
    }
}
