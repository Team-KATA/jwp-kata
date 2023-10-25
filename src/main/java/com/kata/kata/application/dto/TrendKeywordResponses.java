package com.kata.kata.application.dto;

import com.kata.kata.domain.Trend;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class TrendKeywordResponses {

    private LocalDateTime time;
    private List<TrendKeywordResponse> keywords;

    public TrendKeywordResponses(LocalDateTime time, List<TrendKeywordResponse> keywords) {
        this.time = time;
        this.keywords = keywords;
    }

    public static TrendKeywordResponses of(Trend trend, List<TrendKeywordResponse> keywords) {
        return new TrendKeywordResponses(trend.getTime(), keywords);
    }
}
