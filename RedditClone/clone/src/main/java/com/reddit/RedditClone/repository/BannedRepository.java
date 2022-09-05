package com.reddit.RedditClone.repository;

import com.reddit.RedditClone.model.Banned;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BannedRepository extends JpaRepository<Banned, Long> {

    List<Banned> findAllById(Long id);
}
