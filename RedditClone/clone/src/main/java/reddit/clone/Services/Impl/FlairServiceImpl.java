package reddit.clone.Services.Impl;

import org.springframework.stereotype.Component;
import reddit.clone.Repository.FlairRepository;
import reddit.clone.Services.FlairService;
import reddit.clone.model.domain.Flair;
import reddit.clone.model.domain.User;
import reddit.clone.model.dto.FlairDTO;
import reddit.clone.model.dto.UserDTO;

import java.util.List;
import java.util.Optional;

@Component
public class FlairServiceImpl implements FlairService {


    private FlairRepository flairRepository;


    @Override
    public Flair add(FlairDTO dto) {
        Flair flair = new Flair();
        flair.setName(dto.getName());
        flairRepository.save(flair);
        return flair;
    }

    @Override
    public List<Flair> getAll() {
        return flairRepository.findAll();
    }

    @Override
    public Flair getOne(long id) {
        Optional<Flair> flair = flairRepository.findById(id);

        if(flair.isEmpty()) {
            return null;
        }

        return flair.get();
    }

    @Override
    public Flair update(long id, FlairDTO dto) {
        Optional<Flair> flair = flairRepository.findById(id);

        if(flair.isEmpty()) {
            return null;
        }
        flair.get().setName(dto.getName());
        return flairRepository.save(flair.get());
    }

    @Override
    public Flair delete(long id) {
        Optional<Flair> flair = flairRepository.findById(id);

        if(flair.isEmpty()) {
            return null;

        }
        flair.get().setDeleted(true);
        return flairRepository.save(flair.get());
    }
}
