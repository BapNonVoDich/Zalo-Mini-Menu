package com.zalominimenu.springboot.dto.customer_portal;

import lombok.Data;

@Data
public class GetTokenRequest {
    private String phoneToken;
    private String accessToken;
}
