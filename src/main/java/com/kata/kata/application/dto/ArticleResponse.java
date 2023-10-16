package com.kata.kata.application.dto;

import com.kata.kata.domain.Article;
import com.kata.kata.domain.ArticleKeyword;
import com.kata.kata.domain.ArticleSummary;
import com.kata.kata.fixture.SentimentPreferenceFixture;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class ArticleResponse {

    private String title;
    private String body;
    private int sentiment;
    private List<String> hashtags;
    private LocalDateTime time;
    private String press;
    private String reporter;

    public ArticleResponse(
            final String title,
            final String body,
            final Integer sentiment,
            final List<String> hashtags,
            final LocalDateTime time,
            final String press,
            final String reporter
    ) {
        this.title = title;
        this.body = body;
        this.sentiment = sentiment;
        this.hashtags = hashtags;
        this.time = time;
        this.press = press;
        this.reporter = reporter;
    }

    public static ArticleResponse of(ArticleSummary articleSummary, List<String> sentiments) {
        Article article = articleSummary.getArticle();
        return new ArticleResponse(
                article.getTitle(),
                articleSummary.getBody(),
                SentimentPreferenceFixture.NEUTRAL,
                sentiments,
                article.getTime(),
                article.getPress(),
                article.getReporter()
        );
    }
}
