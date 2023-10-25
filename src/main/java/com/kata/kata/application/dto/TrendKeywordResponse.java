package com.kata.kata.application.dto;

import com.kata.kata.domain.Keyword;
import com.kata.kata.domain.TrendKeyword;
import com.kata.kata.fixture.SentimentPreferenceFixture;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class TrendKeywordResponse {

    private Long keyword_id;
    private String keyword;
    private int ranking;
    private int hits;
    private int sentiment;

    public TrendKeywordResponse(Long keyword_id, String keyword, int ranking, int hits, int sentiment) {
        this.keyword_id = keyword_id;
        this.keyword = keyword;
        this.ranking = ranking;
        this.hits = hits;
        this.sentiment = sentiment;
    }

    public static TrendKeywordResponse of(TrendKeyword trendKeyword, int hits) {
        Keyword keyword = trendKeyword.getKeyword();
        return new TrendKeywordResponse(
                keyword.getId(),
                keyword.getName(),
                trendKeyword.getRanking(),
                hits,
                SentimentPreferenceFixture.NEUTRAL
        );
    }
}
