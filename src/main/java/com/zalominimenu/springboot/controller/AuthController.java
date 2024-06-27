package com.zalominimenu.springboot.controller;

import com.zalominimenu.springboot.dto.auth.LoginRequest;
import com.zalominimenu.springboot.dto.auth.LoginResponse;
import com.zalominimenu.springboot.security.jwt.JwtTokenService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/auth")
@Slf4j
public class AuthController {

	private final JwtTokenService jwtTokenService;

	@PostMapping("/login")
	public ResponseEntity<LoginResponse> loginRequest(@Valid @RequestBody LoginRequest loginRequest) {

		final LoginResponse loginResponse = jwtTokenService.getLoginResponse(loginRequest);

		return ResponseEntity.ok(loginResponse);
	}

}
