package com.reddit.RedditClone.repository;

import java.util.List;

import com.reddit.RedditClone.model.Community;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;


public interface CommunityRepository extends JpaRepository<Community, Long> {

    List<Community> findAllById(Long id);

    @Query("select c from Community c where c.id =?1")
    Community findOneById(Long communityId);
}
