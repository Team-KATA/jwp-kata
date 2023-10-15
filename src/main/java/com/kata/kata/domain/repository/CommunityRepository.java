package com.kata.kata.domain.repository;

import com.kata.kata.domain.ArticleKeyword;
import com.kata.kata.domain.Community;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.EntityNotFoundException;

public interface CommunityRepository extends JpaRepository<Community, Long> {

    default Community get(Long id) {
        return findById(id).orElseThrow(EntityNotFoundException::new);
    }
}
