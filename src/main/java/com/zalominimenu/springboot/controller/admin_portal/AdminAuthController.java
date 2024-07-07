package com.zalominimenu.springboot.controller.admin_portal;

import com.zalominimenu.springboot.dto.BaseResponse;
import com.zalominimenu.springboot.dto.admin_portal.auth.LoginRequest;
import com.zalominimenu.springboot.dto.admin_portal.auth.LoginResponse;
import com.zalominimenu.springboot.security.jwt.JwtTokenService;
import com.zalominimenu.springboot.utils.CustomResponseEntity;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/admin-portal/auth")
@Slf4j
public class AdminAuthController {
	private final JwtTokenService jwtTokenService;

	@PostMapping("/login")
	public ResponseEntity<BaseResponse<LoginResponse>> loginRequest(@Valid @RequestBody LoginRequest loginRequest) {
		final LoginResponse loginResponse = jwtTokenService.getLoginResponse(loginRequest);

		return CustomResponseEntity.ok(loginResponse, "Đăng nhập thành công");
	}
}
