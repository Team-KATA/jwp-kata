package com.kata.kata.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Community {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "source", nullable = false)
    private String source;

    @Column(name = "body", nullable = false)
    private String body;

    @Column(name = "link", nullable = false)
    private String link;

    @Column(name = "time", nullable = false)
    private LocalDateTime time;

    public Community(
            Long id,
            String source,
            String body,
            String link,
            LocalDateTime time
    ) {
        this.id = id;
        this.source = source;
        this.body = body;
        this.link = link;
        this.time = time;
    }

    public Community(
            String source,
            String body,
            String link,
            LocalDateTime time
    ) {
        this(null, source, body, link, time);
    }
}
