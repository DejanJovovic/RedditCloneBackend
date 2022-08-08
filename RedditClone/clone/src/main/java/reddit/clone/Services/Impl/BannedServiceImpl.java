package reddit.clone.Services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reddit.clone.Repository.BannedRepository;
import reddit.clone.Services.BannedService;
import reddit.clone.model.domain.Banned;
import reddit.clone.model.dto.BannedDTO;

import java.util.List;
import java.util.Optional;

@Component
public class BannedServiceImpl implements BannedService {

    @Autowired
    private BannedRepository bannedRepository;

    @Override
    public Banned add(BannedDTO dto) {

        Banned banned = new Banned();
        banned.setTimestamp(dto.getTimestamp());

        bannedRepository.save(banned);
        return banned;
    }

    @Override
    public Banned update(long id, BannedDTO dto) {
        Optional<Banned> banned = bannedRepository.findById(id);

        if(banned.isEmpty()) {
            return null;
        }

        banned.get().setTimestamp(dto.getTimestamp());

        return bannedRepository.save(banned.get());
    }

    @Override
    public List<Banned> getAll() {
        return bannedRepository.findAll();
    }

    @Override
    public Banned getOne(long id) {
        Optional<Banned> banned = bannedRepository.findById(id);

        if(banned.isEmpty()) {
            return null;
        }
        return banned.get();
    }

    @Override
    public Banned delete(long id) {
        Optional<Banned> banned = bannedRepository.findById(id);

        if(banned.isEmpty()) {
            return null;
        }
        banned.get().setDeleted(true);
        return bannedRepository.save(banned.get());
    }
}
