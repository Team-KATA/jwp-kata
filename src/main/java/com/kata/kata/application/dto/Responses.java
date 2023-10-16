package com.kata.kata.application.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Responses<T> {

    private List<T> data;

    public Responses(
            List<T> data
            ) {
        this.data = data;
    }

    public static <T> Responses<T> of(List<T> data) {
        return new Responses<>(data);
    }
}
