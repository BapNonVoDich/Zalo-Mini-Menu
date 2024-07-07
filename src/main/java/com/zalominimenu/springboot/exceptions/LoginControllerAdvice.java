package com.zalominimenu.springboot.exceptions;

import com.zalominimenu.springboot.controller.admin_portal.AdminAuthController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice(basePackageClasses = AdminAuthController.class)
@Slf4j
public class LoginControllerAdvice {

	@ExceptionHandler(BadCredentialsException.class)
	ResponseEntity<ApiExceptionResponse> handleRegistrationException(BadCredentialsException exception) {
		final ApiExceptionResponse response = new ApiExceptionResponse(exception.getMessage(), HttpStatus.UNAUTHORIZED, LocalDateTime.now());

		return ResponseEntity.status(response.getStatus()).body(response);
	}
}
