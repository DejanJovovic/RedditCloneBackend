package reddit.clone.Services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reddit.clone.Repository.CommunityRepository;
import reddit.clone.Services.CommunityService;
import reddit.clone.model.domain.Community;
import reddit.clone.model.dto.CommunityDTO;
import reddit.clone.model.dto.UserDTO;

import java.util.List;
import java.util.Optional;

@Component
public class CommunityServiceImpl implements CommunityService {

    @Autowired
   private CommunityRepository communityRepository;

    @Override
    public Community add(CommunityDTO dto) {

        Community community = new Community();
        community.setName(dto.getName());
        community.setDescription(dto.getDescription());
        community.setCreationDate(dto.getCreationDate());
        community.setSuspendedReason(dto.getSuspendedReason());
        community.setSuspended(dto.isSuspended());
        communityRepository.save(community);
        return community;
    }

    @Override
    public List<Community> getAll() {
        return communityRepository.findAll();
    }

    @Override
    public Community getOne(long id) {
        Optional<Community> community = communityRepository.findById(id);

        if(community.isEmpty()) {
            return null;
        }

        return community.get();
    }

    @Override
    public Community update(long id, CommunityDTO dto) {
        Optional<Community> community = communityRepository.findById(id);

        if(community.isEmpty()) {
            return null;
        }
        community.get().setName(dto.getName());
        community.get().setDescription(dto.getDescription());
        community.get().setCreationDate(dto.getCreationDate());
        community.get().setSuspendedReason(dto.getSuspendedReason());
        community.get().setSuspended(dto.isSuspended());

        return communityRepository.save(community.get());
    }

    @Override
    public Community delete(long id) {
        Optional<Community> community = communityRepository.findById(id);

        if(community.isEmpty()) {
            return null;
        }
        community.get().setDeleted(true);
        return communityRepository.save(community.get());
    }

    @Override
    public Community save(Community community) {
        try{
            return communityRepository.save(community);
        }catch (IllegalArgumentException e) {
            return null;
        }
    }
}
