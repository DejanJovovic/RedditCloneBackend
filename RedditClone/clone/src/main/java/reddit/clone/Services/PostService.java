package reddit.clone.Services;

import reddit.clone.model.domain.Post;
import reddit.clone.model.dto.PostDTO;

public interface PostService {
    Post add(PostDTO dto);

    Post getAll();
    Post getOne(long id);

    Post update(long id);

    Post delete(long id);

}
