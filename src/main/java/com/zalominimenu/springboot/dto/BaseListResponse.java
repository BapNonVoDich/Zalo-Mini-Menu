package com.zalominimenu.springboot.dto;

import lombok.Data;

import java.util.List;

@Data
public class BaseListResponse<T> {
    private List<T> data;
    private String message;
    private Meta meta;
}

