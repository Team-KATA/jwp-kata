package com.kata.kata.domain.repository;

import com.kata.kata.domain.Community;
import com.kata.kata.domain.CommunitySentiment;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;

public interface CommunitySentimentRepository extends JpaRepository<CommunitySentiment, Long> {

    List<CommunitySentiment> findAllByCommunity(Community community);
  
    default CommunitySentiment get(Long id) {
        return findById(id).orElseThrow(EntityNotFoundException::new);
    }
}
