package com.reddit.RedditClone.service;



import com.reddit.RedditClone.dto.PostDTO;
import com.reddit.RedditClone.model.Post;

import java.util.List;

public interface PostService {
    Post add(PostDTO dto);

    List<Post> getAll();
    Post getOne(Long id);

    Post update(Long id, PostDTO dto);

    Post delete(Long id);

    Post save(Post post);

    List<Post> findAllByCommunity(Long id);

    List<Post> findAll();

    Post findOneById(Long postId);

}
