package reddit.clone.Services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reddit.clone.Repository.PostRepository;
import reddit.clone.Services.PostService;
import reddit.clone.model.domain.Post;
import reddit.clone.model.dto.PostDTO;
import reddit.clone.model.dto.UserDTO;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;


@Component
public class PostServiceImpl implements PostService{

    @Autowired
    private PostRepository postRepository;

    @Override
    public Post add(PostDTO dto) {
        Post post = new Post();
        post.setTitle(dto.getTitle());
        post.setText(dto.getText());
        post.setCreationDate(dto.getCreationDate());
        post.setImagePath(dto.getImagePath());
        postRepository.save(post);
        return post;
    }

    @Override
    public List<Post> getAll() {
        return postRepository.findAll();
    }


    @Override
    public Post save(Post post) {
        return postRepository.save(post);
    }

    @Override
    public List<Post> findAllByCommunity(Long id) {

        return postRepository.findAllByCommunity(id);
    }

    @Override
    public Post getOne(Long id) {
        Optional<Post> post = postRepository.findById(id);

        if(post.isEmpty()) {
            return null;
        }
        return post.get();
    }

    @Override
    public Post update(Long id, PostDTO dto) {
        Optional<Post> post = postRepository.findById(id);

        if(post.isEmpty()) {
            return null;
        }
        post.get().setTitle(dto.getTitle());
        post.get().setText(dto.getText());
        post.get().setCreationDate(dto.getCreationDate());
        post.get().setImagePath(dto.getImagePath());
        return postRepository.save(post.get());
    }

    @Override
    public Post delete(Long id) {
        Optional<Post> post = postRepository.findById(id);

        if(post.isEmpty()) {
            return null;
        }
        post.get().setDeleted(true);
        return postRepository.save(post.get());
    }
}
