package reddit.clone.Services;

import reddit.clone.model.domain.Comment;
import reddit.clone.model.domain.Post;
import reddit.clone.model.dto.CommentDTO;
import reddit.clone.model.dto.PostDTO;

import java.util.List;

public interface CommentService {

    Comment add(CommentDTO dto);

    List<Comment> getAll();
    Comment getOne(long id);

    Comment update(long id, CommentDTO dto);

    Comment delete(long id);

}

