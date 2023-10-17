package com.kata.kata.domain;

import com.kata.kata.fixture.DayFixture;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "body", nullable = false)
    private String body;

    @Column(name = "reporter", nullable = false)
    private String reporter;

    @Column(name = "press", nullable = false)
    private String press;

    @Column(name = "link", nullable = false)
    private String link;

    @Column(name = "time", nullable = false)
    private LocalDateTime time;

    public Article(
            Long id,
            String title,
            String body,
            String reporter,
            String press,
            String link,
            LocalDateTime time
    ) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.reporter = reporter;
        this.press = press;
        this.link = link;
        this.time = time;
    }

    public Article(
            String title,
            String body,
            String reporter,
            String press,
            String link,
            LocalDateTime time
    ) {
        this(null, title, body, reporter, press, link, time);
    }

    public boolean isNotExpired(LocalDateTime standard) {
        return time.isAfter(standard.minusDays(DayFixture.ONE_DAY));
    }
}
