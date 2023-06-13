package com.reddit.RedditClone.repository;

import com.reddit.RedditClone.model.IndexPost;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface IndexPostRepository extends ElasticsearchRepository<IndexPost, Long> {
}
