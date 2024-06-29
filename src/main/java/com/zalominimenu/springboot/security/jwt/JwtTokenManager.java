package com.zalominimenu.springboot.security.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.zalominimenu.springboot.dto.admin_portal.auth.AuthToken;
import com.zalominimenu.springboot.enums.TokenType;
import com.zalominimenu.springboot.enums.AdminRole;
import com.zalominimenu.springboot.model.AdminUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@RequiredArgsConstructor
public class JwtTokenManager {

	private final JwtProperties jwtProperties;

	public String generateToken(AdminUser user, TokenType tokenType, Long expiresInMinutes) {
		final String username = user.getUsername();
		final AdminRole userRole = user.getRole();

		return JWT.create()
				.withSubject(username)
				.withIssuer(jwtProperties.getIssuer())
				.withClaim("role", userRole.name())
				.withClaim("type", tokenType.name())
				.withIssuedAt(new Date())
				.withExpiresAt(new Date(System.currentTimeMillis() + expiresInMinutes * 60 * 1000))
				.sign(Algorithm.HMAC256(jwtProperties.getSecretKey().getBytes()));
	}

	public AuthToken generateAuthToken(AdminUser user) {
		final String accessToken = generateToken(user, TokenType.ACCESS, jwtProperties.getAccessExpirationMinute());
		final String refreshToken = generateToken(user, TokenType.REFRESH, jwtProperties.getRefreshExpirationMinute());
		return new AuthToken(accessToken, refreshToken, jwtProperties.getAccessExpirationMinute(), jwtProperties.getRefreshExpirationMinute());
	}

	public String getUsernameFromToken(String token) {

		final DecodedJWT decodedJWT = getDecodedJWT(token);

		return decodedJWT.getSubject();
	}

	public boolean validateToken(String token, String authenticatedUsername) {

		final String usernameFromToken = getUsernameFromToken(token);

		final boolean equalsUsername = usernameFromToken.equals(authenticatedUsername);
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
