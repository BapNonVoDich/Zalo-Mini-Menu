package com.zalominimenu.springboot.dto.customer_portal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AuthToken {
    private String accessToken;
    private String refreshToken;
    private Long accessTokenExpirationIn;
    private Long refreshTokenExpirationIn;
}
