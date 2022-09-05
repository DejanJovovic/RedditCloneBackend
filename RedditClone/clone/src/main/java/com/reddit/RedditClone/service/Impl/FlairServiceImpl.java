package com.reddit.RedditClone.service.Impl;

import com.reddit.RedditClone.dto.FlairDTO;
import com.reddit.RedditClone.model.Flair;
import com.reddit.RedditClone.repository.FlairRepository;
import com.reddit.RedditClone.service.FlairService;
import org.springframework.stereotype.Component;

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
    public Flair getOne(Long id) {
        Optional<Flair> flair = flairRepository.findById(id);

        if(flair.isEmpty()) {
            return null;
        }

        return flair.get();
    }

    @Override
    public Flair update(Long id, FlairDTO dto) {
        Optional<Flair> flair = flairRepository.findById(id);

        if(flair.isEmpty()) {
            return null;
        }
        flair.get().setName(dto.getName());
        return flairRepository.save(flair.get());
    }

    @Override
    public Flair delete(Long id) {
        Optional<Flair> flair = flairRepository.findById(id);

        if(flair.isEmpty()) {
            return null;

        }
        flair.get().setDeleted(true);
        return flairRepository.save(flair.get());
    }
}
