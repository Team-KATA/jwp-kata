package com.kata.kata.application.dto;

import com.kata.kata.domain.Trend;
import com.kata.kata.domain.TrendOpinion;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class TrendHitsResponse {

    private LocalDateTime time;
    private int hits;

    public TrendHitsResponse(LocalDateTime time, int hits) {
        this.time = time;
        this.hits = hits;
    }

    public static TrendHitsResponse of(TrendOpinion trendOpinion) {
        Trend trend = trendOpinion.getTrend();
        return new TrendHitsResponse(trend.getTime(), trendOpinion.getHits());
    }
}
