package com.kata.kata.application;

import com.kata.kata.application.dto.ArticleResponse;
import com.kata.kata.domain.Article;
import com.kata.kata.domain.ArticleSummary;
import com.kata.kata.domain.repository.ArticleRepository;
import com.kata.kata.domain.repository.ArticleSummaryRepository;
import com.kata.kata.support.ApplicationTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;

@ApplicationTest
public class ArticleServiceTest {

    @Autowired
    private ArticleService articleService;
    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private ArticleSummaryRepository articleSummaryRepository;

    @Test
    void findArticle() {
        Article article = articleRepository.save(new Article("새벽에 쏜 순항미사일, 백령도 노렸나", "본문", "기자", "언론사", "링크", LocalDateTime.now()));
        articleSummaryRepository.save(new ArticleSummary(article, "요약한 본문"));

        assertThatNoException().isThrownBy(
                () -> articleService.findArticle(article.getId()));
    }

    @Test
    void test() {
        Article article = articleRepository.save(new Article("새벽에 쏜 순항미사일, 백령도 노렸나", "본문", "기자", "언론사", "링크", LocalDateTime.now()));
        articleSummaryRepository.save(new ArticleSummary(article, "요약한 본문"));
        Article article2 = articleRepository.save(new Article("새벽에 쏜 순항미사일, 백령도 노렸나", "본문", "기자", "언론사", "링크", LocalDateTime.now()));
        articleSummaryRepository.save(new ArticleSummary(article2, "요약한 본문"));

        List<ArticleResponse> responses = articleService.findAllArticle();

        assertThat(responses).hasSize(2);
    }

}
