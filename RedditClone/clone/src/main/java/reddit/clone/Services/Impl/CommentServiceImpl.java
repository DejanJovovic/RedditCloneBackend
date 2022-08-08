package reddit.clone.Services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reddit.clone.Repository.CommentRepository;
import reddit.clone.Services.CommentService;
import reddit.clone.model.domain.Comment;
import reddit.clone.model.dto.CommentDTO;
import reddit.clone.model.dto.UserDTO;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Component
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public Comment add(CommentDTO dto) {

        Comment comment = new Comment();
        comment.setText(dto.getText());
        comment.setTimestamp(dto.getTimestamp());
        comment.setDeleted(dto.isDeleted());
        commentRepository.save(comment);
        return comment;
    }

    @Override
    public List<Comment> getAll() {

        return commentRepository.findAll();
    }

    @Override
    public Comment getOne(long id) {
        Optional<Comment> comment = commentRepository.findById(id);

        if(comment.isEmpty()) {
            return null;
        }

        return comment.get();
    }

    @Override
    public Comment update(long id, CommentDTO dto) {
        Optional<Comment> comment = commentRepository.findById(id);

        if(comment.isEmpty()) {
            return null;
        }
        comment.get().setText(dto.getText());
        comment.get().setTimestamp(dto.getTimestamp());
        comment.get().setDeleted(dto.isDeleted());
     return commentRepository.save(comment.get());
    }

    @Override
    public Comment delete(long id) {
        Optional<Comment> comment = commentRepository.findById(id);

        if(comment.isEmpty()) {
            return null;
        }
        comment.get().setDeleted(true);
        return commentRepository.save(comment.get());
    }
}
