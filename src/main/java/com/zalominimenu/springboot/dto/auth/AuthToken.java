package com.zalominimenu.springboot.dto.auth;

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
