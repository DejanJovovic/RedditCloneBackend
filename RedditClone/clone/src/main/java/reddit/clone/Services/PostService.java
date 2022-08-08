package reddit.clone.Services;

import reddit.clone.model.domain.Post;
import reddit.clone.model.dto.PostDTO;

import java.util.List;

public interface PostService {
    Post add(PostDTO dto);

    List<Post> getAll();
    Post getOne(long id);

    Post update(long id, PostDTO dto);

    Post delete(long id);

}
