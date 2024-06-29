package com.zalominimenu.springboot.utils;

import com.zalominimenu.springboot.dto.BaseResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;

public class CustomResponseEntity {
    public static <T> ResponseEntity<BaseResponse<T>> ok(@Nullable T data, String message) {
        return ResponseEntity.ok(new BaseResponse<T>(data, message));
    }
}
