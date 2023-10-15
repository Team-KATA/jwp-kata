package com.kata.kata.application;

import com.kata.kata.application.dto.ArticleKeywordResponse;
import com.kata.kata.domain.ArticleKeyword;
import com.kata.kata.domain.Keyword;
import com.kata.kata.domain.repository.ArticleKeywordRepository;
import com.kata.kata.domain.repository.ArticleSentimentRepository;
import com.kata.kata.domain.repository.KeywordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Transactional
@Service
public class KeywordService {

    private final KeywordRepository keywordRepository;
    private final ArticleKeywordRepository articleKeywordRepository;
    private final ArticleSentimentRepository articleSentimentRepository;

    @Transactional(readOnly = true)
    public List<ArticleKeywordResponse> findArticleKeywords(Long id) {
        Keyword keyword = keywordRepository.get(id);
        List<ArticleKeyword> articleKeywords = articleKeywordRepository.findByKeyword(keyword);
        return articleKeywords.stream()
                .map(it -> ArticleKeywordResponse.of(it, articleSentimentRepository.findAllByArticle(it.getArticle()).stream()
                        .map(sentiment -> sentiment.getSentiment()
                                .getHashtag())
                        .collect(Collectors.toList())))
                .collect(Collectors.toList());
    }
}
