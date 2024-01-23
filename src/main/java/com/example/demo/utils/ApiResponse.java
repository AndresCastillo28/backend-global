package com.example.demo.utils;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiResponse<T> {

    private boolean success;
    private T data;
    private ApiError error;

    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(true, data, null);
    }

    public static <T> ApiResponse<T> error(int errorCode, String errorMessage) {
        return new ApiResponse<>(false, null, new ApiError(errorCode, errorMessage));
    }

    @Data
    @AllArgsConstructor
    public static class ApiError {
        private int code;
        private String message;
    }
}