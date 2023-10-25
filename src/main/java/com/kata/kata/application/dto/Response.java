package com.kata.kata.application.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Response<T> {

    private T data;

    public Response(
            T data
    ) {
        this.data = data;
    }

    public static <T> Response<T> of(T data) {
        return new Response<>(data);
    }
}
