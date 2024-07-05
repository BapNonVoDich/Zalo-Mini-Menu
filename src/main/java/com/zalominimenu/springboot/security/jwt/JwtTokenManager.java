package com.zalominimenu.springboot.security.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.zalominimenu.springboot.dto.admin_portal.auth.AuthToken;
import com.zalominimenu.springboot.enums.TokenType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@RequiredArgsConstructor
public class JwtTokenManager {

	private final JwtProperties jwtProperties;

	public String generateToken(Long id,String role, TokenType tokenType, Long expiresInMinutes) {

		return JWT.create()
				.withSubject(id.toString())
				.withIssuer(jwtProperties.getIssuer())
				.withClaim("role", role)
				.withClaim("type", tokenType.name())
				.withIssuedAt(new Date())
				.withExpiresAt(new Date(System.currentTimeMillis() + expiresInMinutes * 60 * 1000))
				.sign(Algorithm.HMAC256(jwtProperties.getSecretKey().getBytes()));
	}

	public AuthToken generateAuthToken(Long userId, String role) {
		final String accessToken = generateToken(userId,role, TokenType.ACCESS, jwtProperties.getAccessExpirationMinute());
		final String refreshToken = generateToken(userId,role, TokenType.REFRESH, jwtProperties.getRefreshExpirationMinute());
		return new AuthToken(accessToken, refreshToken, jwtProperties.getAccessExpirationMinute(), jwtProperties.getRefreshExpirationMinute());
	}

	public String getSubjectFromToken(String token) {
		final DecodedJWT decodedJWT = getDecodedJWT(token);
		return decodedJWT.getSubject();
	}

	public boolean validateToken(String token, String authenticatedUserId) {

		final String userIdFromToken = getSubjectFromToken(token);

		final boolean equalsUsername = userIdFromToken.equals(authenticatedUserId);
		final boolean tokenExpired = isTokenExpired(token);

		return equalsUsername && !tokenExpired;
	}

	private boolean isTokenExpired(String token) {

		final Date expirationDateFromToken = getExpirationDateFromToken(token);
		return expirationDateFromToken.before(new Date());
	}

	private Date getExpirationDateFromToken(String token) {

		final DecodedJWT decodedJWT = getDecodedJWT(token);

		return decodedJWT.getExpiresAt();
	}

	private DecodedJWT getDecodedJWT(String token) {

		final JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(jwtProperties.getSecretKey().getBytes())).build();

		return jwtVerifier.verify(token);
	}

}
