package com.zalominimenu.springboot.security.jwt;

import com.zalominimenu.springboot.dto.admin_portal.auth.*;
import com.zalominimenu.springboot.mapper.AdminUserMapper;
import com.zalominimenu.springboot.model.AdminUser;
import com.zalominimenu.springboot.service.admin_portal.AdminUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class JwtTokenService {

	private final AdminUserService adminUserService;

	private final JwtTokenManager jwtTokenManager;

	private final AuthenticationManager authenticationManager;

	public LoginResponse getLoginResponse(LoginRequest loginRequest) {

		final String username = loginRequest.getUsername();
		final String password = loginRequest.getPassword();

		final UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(username, password);

		authenticationManager.authenticate(usernamePasswordAuthenticationToken);

		final AdminUser user = adminUserService.findByUsername(username);
		final AuthToken token = jwtTokenManager.generateAuthToken(user);
		final UserInfo userInfo = AdminUserMapper.INSTANCE.convertToUserInfo(user);
		log.info("{} has successfully logged in!", user.getUsername());

		return new LoginResponse(token, userInfo);
	}

}
