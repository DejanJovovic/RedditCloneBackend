package reddit.clone.Services.Impl;

import org.springframework.stereotype.Component;
import reddit.clone.Repository.ReactionRepository;
import reddit.clone.Services.ReactionService;
import reddit.clone.model.domain.Reaction;
import reddit.clone.model.dto.ReactionDTO;
import reddit.clone.model.dto.UserDTO;

import java.util.List;
import java.util.Optional;

@Component
public class ReactionServiceImpl implements ReactionService {

    private ReactionRepository reactionRepository;



    @Override
    public Reaction add(ReactionDTO dto) {
        Reaction reaction = new Reaction();
        reaction.setType(dto.getType());
        reaction.setTimestamp(dto.getTimestamp());
        reactionRepository.save(reaction);
        return reaction;
    }

    @Override
    public List<Reaction> getAll() {
        return reactionRepository.findAll();
    }

    @Override
    public Reaction getOne(long id) {
        Optional<Reaction> reaction = reactionRepository.findById(id);

        if(reaction.isEmpty()) {
            return null;
        }

        return reaction.get();
    }

    @Override
    public Reaction update(long id, ReactionDTO dto) {
        Optional<Reaction> reaction = reactionRepository.findById(id);

        if(reaction.isEmpty()) {
            return null;
        }
        reaction.get().setType(dto.getType());
        reaction.get().setTimestamp(dto.getTimestamp());
        return reactionRepository.save(reaction.get());
    }

    @Override
    public Reaction delete(long id) {
        Optional<Reaction> reaction = reactionRepository.findById(id);

        if(reaction.isEmpty()) {
            return null;
        }
        reaction.get().setDeleted(true);
        return reactionRepository.save(reaction.get());
    }
}
