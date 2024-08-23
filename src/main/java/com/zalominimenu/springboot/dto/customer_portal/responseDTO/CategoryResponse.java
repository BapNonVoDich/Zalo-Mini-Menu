package com.zalominimenu.springboot.dto.customer_portal.responseDTO;

import lombok.Data;

@Data
public class CategoryResponse {
    private Long id;
    private String categoryName;
    private String description;
    private StoreResponse store;
}
