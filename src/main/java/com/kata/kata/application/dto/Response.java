package com.kata.kata.application.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Response<T> {

    private List<T> data;

    public Response (
            List<T> data
            ) {
        this.data = data;
    }

    public static <T> Response<T> of(List<T> data) {
        return new Response<>(data);
    }
}
