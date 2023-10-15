package com.kata.kata.application.dto;

import com.kata.kata.domain.Article;
import com.kata.kata.domain.ArticleKeyword;
import com.kata.kata.fixture.SentimentPreferenceFixture;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class ArticleKeywordResponse {

    private String title;
    private int sentiment;
    private List<String> hashtags;
    private LocalDateTime time;
    private String press;
    private String reporter;

    public ArticleKeywordResponse(
            final String title,
            final Integer sentiment,
            final List<String> hashtags,
            final LocalDateTime time,
            final String press,
            final String reporter
    ) {
        this.title = title;
        this.sentiment = sentiment;
        this.hashtags = hashtags;
        this.time = time;
        this.press = press;
        this.reporter = reporter;
    }

    public static ArticleKeywordResponse of(ArticleKeyword articleKeyword, List<String> sentiments) {
        final Article article = articleKeyword.getArticle();
        return new ArticleKeywordResponse(
                articleKeyword.getKeyword().getName(),
                SentimentPreferenceFixture.NEUTRAL,
                sentiments,
                article.getTime(),
                article.getPress(),
                article.getReporter()
        );
    }
}
