package reddit.clone.Services;

import reddit.clone.model.domain.Comment;
import reddit.clone.model.domain.Post;
import reddit.clone.model.dto.CommentDTO;
import reddit.clone.model.dto.PostDTO;

public interface CommentService {

    Comment add(CommentDTO dto);

    Comment getAll();
    Comment getOne(long id);

    Comment update(long id);

    Comment delete(long id);

}

