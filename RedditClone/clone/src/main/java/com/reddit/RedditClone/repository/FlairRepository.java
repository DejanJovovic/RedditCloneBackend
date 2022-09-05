package com.reddit.RedditClone.repository;

import com.reddit.RedditClone.model.Flair;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface FlairRepository extends JpaRepository<Flair, Long> {

    List<Flair> findAllById(Long id);
}
