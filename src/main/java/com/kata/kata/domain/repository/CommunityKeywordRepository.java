package com.kata.kata.domain.repository;

import com.kata.kata.domain.CommunityKeyword;
import com.kata.kata.domain.Keyword;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;

public interface CommunityKeywordRepository extends JpaRepository<CommunityKeyword, Long> {

    List<CommunityKeyword> findByKeyword(Keyword keyword);

    default CommunityKeyword get(Long id) {
        return findById(id).orElseThrow(EntityNotFoundException::new);
    }
}
