package com.zalominimenu.springboot.dto.customer_portal.responseDTO;

import lombok.Data;

import java.util.Set;

@Data
public class ProductResponse {
    private Long id;

    private String productName;

    private String description;

    private Long productPrice;

    private Set<CategoryResponse> categories;

    private Long stockQuantity;

    private StoreResponse store;

    private String imageURL;
}
