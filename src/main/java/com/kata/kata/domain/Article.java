package com.kata.kata.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

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

    @Column(name = "media", nullable = false)
    private String media;

    @Column(name = "link", nullable = false)
    private String link;

    @Column(name = "time", nullable = false)
    private LocalDateTime time;

    public Article(
            Long id,
            String title,
            String body,
            String reporter,
            String media,
            String link,
            LocalDateTime time
    ) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.reporter = reporter;
        this.media = media;
        this.link = link;
        this.time = time;
    }

    public Article(
            String title,
            String body,
            String reporter,
            String media,
            String link,
            LocalDateTime time
    ) {
        this(null, title, body, reporter, media, link, time);
    }
}
