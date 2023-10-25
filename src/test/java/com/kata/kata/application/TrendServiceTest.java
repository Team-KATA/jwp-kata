package com.kata.kata.application;

import com.kata.kata.application.dto.TrendKeywordResponse;
import com.kata.kata.domain.*;
import com.kata.kata.domain.repository.*;
import com.kata.kata.fixture.DayFixture;
import com.kata.kata.support.ApplicationTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ApplicationTest
public class TrendServiceTest {

    @Autowired
    private TrendService trendService;
    @Autowired
    private TrendRepository trendRepository;
    @Autowired
    private TrendKeywordRepository trendKeywordRepository;
    @Autowired
    private KeywordRepository keywordRepository;
    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private ArticleKeywordRepository articleKeywordRepository;

    @Test
    void findTrendKeywords() {
        Trend trend = trendRepository.save(new Trend(LocalDateTime.now()));
        Keyword keyword = keywordRepository.save(new Keyword("육군"));
        trendKeywordRepository.save(new TrendKeyword(keyword, trend, 1));
        Article article = articleRepository.save(new Article("새벽에 쏜 순항미사일, 백령도 노렸나", "본문", "기자", "언론사", "링크", LocalDateTime.now().minusDays(DayFixture.ONE_DAY)));
        articleKeywordRepository.save(new ArticleKeyword(article, keyword));

        List<TrendKeywordResponse> responses = trendService.findTrendKeywords(trend.getTime());

        assertThat(responses).hasSize(1);
    }
}
