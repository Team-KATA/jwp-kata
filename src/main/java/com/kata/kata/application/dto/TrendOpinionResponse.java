package com.kata.kata.application.dto;

import com.kata.kata.domain.Trend;
import com.kata.kata.domain.TrendOpinion;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class TrendOpinionResponse {

    private LocalDateTime time;
    private float opinion;

    public TrendOpinionResponse(LocalDateTime time, float opinion) {
        this.time = time;
        this.opinion = opinion;
    }

    public static TrendOpinionResponse of(TrendOpinion trendOpinion) {
        Trend trend = trendOpinion.getTrend();
        return new TrendOpinionResponse(trend.getTime(), trendOpinion.getOpinion());
    }
}
