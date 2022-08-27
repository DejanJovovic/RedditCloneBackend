package reddit.clone.Services;

import reddit.clone.model.domain.Post;
import reddit.clone.model.dto.PostDTO;

import java.util.List;

public interface PostService {
    Post add(PostDTO dto);

    List<Post> getAll();
    Post getOne(Long id);

    Post update(Long id, PostDTO dto);

    Post delete(Long id);

    Post save(Post post);

    List<Post> findAllByCommunity(Long id);

}
