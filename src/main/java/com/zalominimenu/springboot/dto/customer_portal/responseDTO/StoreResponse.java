package com.zalominimenu.springboot.dto.customer_portal.responseDTO;

import lombok.Data;

@Data
public class StoreResponse {
    private Long id;
    private String name;
    private boolean status;
    private String address;
    private String ward;
    private String district;
    private String city;
    private String imageURL;
}
