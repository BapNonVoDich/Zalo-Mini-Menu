package com.zalominimenu.springboot.utils;

import com.zalominimenu.springboot.dto.BaseListResponse;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

public class CustomResponseListEntity {
    public static <T> ResponseEntity<BaseListResponse<T>> ok(Page<T> data, String message) {
        return ResponseEntity.ok(new BaseListResponse<>(data, message));
    }
}
