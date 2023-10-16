package com.kata.kata.application;

import com.kata.kata.application.dto.ArticleKeywordResponse;
import com.kata.kata.application.dto.CommunityKeywordResponse;
import com.kata.kata.domain.*;
import com.kata.kata.domain.repository.*;
import com.kata.kata.support.ApplicationTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ApplicationTest
public class KeywordServiceTest {

    @Autowired
    private KeywordService keywordService;
    @Autowired
    private KeywordRepository keywordRepository;
    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private ArticleKeywordRepository articleKeywordRepository;
    @Autowired
    private CommunityRepository communityRepository;
    @Autowired
    private CommunityKeywordRepository communityKeywordRepository;

    @Test
    void findArticleKeywords() {
        Keyword keyword = keywordRepository.save(new Keyword("육군"));
        Article article = articleRepository.save(new Article("새벽에 쏜 순항미사일, 백령도 노렸나", "본문", "기자", "언론사", "링크", LocalDateTime.now()));
        articleKeywordRepository.save(new ArticleKeyword(article, keyword));

        List<ArticleKeywordResponse> responses = keywordService.findArticleKeywords(keyword.getId());

        assertThat(responses).hasSize(1);
    }

    @Test
    void test() {
        Keyword keyword = keywordRepository.save(new Keyword("육군"));
        Community community = communityRepository.save(new Community("인스타그램", "본문", "링크", LocalDateTime.now()));
        communityKeywordRepository.save(new CommunityKeyword(community, keyword));

        List<CommunityKeywordResponse> responses = keywordService.findCommunitiesByKeyword(keyword.getId());

        assertThat(responses).hasSize(1);
    }
}
