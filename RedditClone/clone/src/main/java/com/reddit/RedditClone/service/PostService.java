package com.reddit.RedditClone.service;

import com.reddit.RedditClone.model.Post;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface PostService {
    Post save(Post post);
    List<Post> findAll();
    Post findOneById(Long postId);
    void remove(Long id);
    List<Post> findAllByCommunity(Long id);

    Post createPost(Post post, MultipartFile pdfFile);
}
