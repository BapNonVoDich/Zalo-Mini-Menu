package com.zalominimenu.springboot.dto;

import lombok.Data;

@Data
public class Meta {
    private int page;
    private int size;
    private int total;
    private int totalPages;
}
