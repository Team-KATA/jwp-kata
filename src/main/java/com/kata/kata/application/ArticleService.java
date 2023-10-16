package com.kata.kata.application;

import com.kata.kata.application.dto.ArticleResponse;
import com.kata.kata.domain.Article;
import com.kata.kata.domain.repository.ArticleRepository;
import com.kata.kata.domain.repository.ArticleSentimentRepository;
import com.kata.kata.domain.repository.ArticleSummaryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Transactional
@Service
public class ArticleService {

    private final ArticleRepository articleRepository;
    private final ArticleSummaryRepository articleSummaryRepository;
    private final ArticleSentimentRepository articleSentimentRepository;

    @Transactional(readOnly = true)
    public ArticleResponse findArticle(Long id) {
        Article article = articleRepository.get(id);
        List<String> sentiments = articleSentimentRepository.findAllByArticle(article)
                .stream()
                .map(it -> it.getSentiment().getHashtag())
                .collect(Collectors.toList());
        return ArticleResponse.of(articleSummaryRepository.findByArticle(article), sentiments);
    }
}
