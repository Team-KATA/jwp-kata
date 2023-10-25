package com.kata.kata.application.dto;

import com.kata.kata.domain.Community;
import com.kata.kata.domain.CommunityKeyword;
import com.kata.kata.fixture.SentimentPreferenceFixture;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class CommunityKeywordResponse {

    private String body;
    private LocalDateTime time;
    private int sentiment;
    private String source;

    public CommunityKeywordResponse(
            final String body,
            final LocalDateTime time,
            final int sentiment,
            final String source
    ) {
        this.body = body;
        this.time = time;
        this.sentiment = sentiment;
        this.source = source;
    }

    public static CommunityKeywordResponse of(CommunityKeyword communityKeyword) {
        Community community = communityKeyword.getCommunity();
        return new CommunityKeywordResponse(
                community.getBody(),
                community.getTime(),
                SentimentPreferenceFixture.NEUTRAL,
                community.getSource()
        );
    }
}
