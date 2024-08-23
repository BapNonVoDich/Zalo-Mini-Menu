package com.zalominimenu.springboot.dto;

import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.List;

@Data
public class BaseListResponse<T> {
    private List<T> data;
    private String message;
    private Meta meta;

    public BaseListResponse(Page<T> page, String message) {
        this.data = page.getContent();
        this.message = message;
        this.meta = new Meta(page);
    }
}

