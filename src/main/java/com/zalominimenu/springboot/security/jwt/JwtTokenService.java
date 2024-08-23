package com.zalominimenu.springboot.security.jwt;

import com.zalominimenu.springboot.dto.admin_portal.auth.AuthToken;
import com.zalominimenu.springboot.dto.admin_portal.auth.LoginRequest;
import com.zalominimenu.springboot.dto.admin_portal.auth.LoginResponse;
import com.zalominimenu.springboot.dto.admin_portal.auth.UserInfo;
import com.zalominimenu.springboot.dto.customer_portal.GetTokenRequest;
import com.zalominimenu.springboot.mapper.AdminUserMapper;
import com.zalominimenu.springboot.model.AdminUser;
import com.zalominimenu.springboot.model.Customer;
import com.zalominimenu.springboot.repository.customer_portal.CustomerRepository;
import com.zalominimenu.springboot.service.admin_portal.AdminUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Slf4j
@Service
@RequiredArgsConstructor
public class JwtTokenService {

	private final AdminUserService adminUserService;

	private final JwtTokenManager jwtTokenManager;

	private final AuthenticationManager authenticationManager;

	private final ZaloService zaloService;

	private final CustomerRepository customerRepository;

	public LoginResponse getLoginResponse(LoginRequest loginRequest) {
		final String username = loginRequest.getUsername();
		final String password = loginRequest.getPassword();

		final UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(username, password);

		authenticationManager.authenticate(usernamePasswordAuthenticationToken);

		final AdminUser user = adminUserService.findByUsername(username);
		final AuthToken token = jwtTokenManager.generateAuthToken(user.getId(), user.getRole().name());
		final UserInfo userInfo = AdminUserMapper.INSTANCE.convertToUserInfo(user);
		log.info("{} has successfully logged in!", user.getUsername());

		return new LoginResponse(token, userInfo);
	}

	public AuthToken getAuthTokenFromZaloPhoneTokenAndAccessToken(GetTokenRequest request) {
		final String customerPhoneNumber =
				zaloService.getUserPhoneNumberFromToken(request.getAccessToken(),request.getPhoneToken());
		if (customerPhoneNumber == null) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Không thể xác thực số điện thoại");
		}

		Customer c = customerRepository.findCustomerByPhoneNumber(customerPhoneNumber);
		if (c == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Số điện thoại chưa được đăng ký tài khoản");
		}

		return jwtTokenManager.generateAuthToken(c.getId(), c.getRole().name());
	}
}
