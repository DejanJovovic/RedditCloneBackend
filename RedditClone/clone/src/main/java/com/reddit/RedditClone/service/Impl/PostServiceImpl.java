package com.reddit.RedditClone.service.Impl;

import com.reddit.RedditClone.model.IndexPost;
import com.reddit.RedditClone.model.Post;
import com.reddit.RedditClone.repository.IndexPostRepository;
import com.reddit.RedditClone.repository.PostRepository;
import com.reddit.RedditClone.service.PostService;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private IndexPostRepository indexPostRepository;

    @Override
    public Post save(Post post) {
        return postRepository.save(post);
    }

    @Override
    public List<Post> findAll() {
        return postRepository.findAll();
    }

    @Override
    public Post findOneById(Long postId) {
        return postRepository.findOneById(postId);
    }

    @Override
    public void remove(Long id) {
        postRepository.deleteById(id);
    }

    @Override
    public List<Post> findAllByCommunity(Long id) {
        return postRepository.findAllByCommunity(id);
    }

    @Override
    public Post createPost(Post post, MultipartFile pdfFile) {
        Post savePost = postRepository.save(post);
        Optional<String> pdfText = parsePdf(pdfFile);
        IndexPost indexPost = new IndexPost(savePost, pdfText.get());
        indexPostRepository.save(indexPost);
        return savePost;
    }

    public Optional<String> parsePdf(MultipartFile file) {
        try (var pdfInputStream = file.getInputStream(); var pddDocument = PDDocument.load(pdfInputStream)) {
            PDFTextStripper pdfStripper = new PDFTextStripper();
            return Optional.of(pdfStripper.getText(pddDocument));
        } catch (Exception e) {
            return Optional.empty();
        }
    }

}
