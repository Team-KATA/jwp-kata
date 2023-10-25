package com.kata.kata.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Trend {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "time", nullable = false)
    private LocalDateTime time;

    public Trend(
            Long id,
            LocalDateTime time
    ) {
        this.id = id;
        this.time = time.truncatedTo(ChronoUnit.SECONDS);
    }

    public Trend(
            LocalDateTime time
    ) {
        this(null, time);
    }
}
