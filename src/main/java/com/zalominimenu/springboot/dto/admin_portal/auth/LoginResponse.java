package com.zalominimenu.springboot.dto.admin_portal.auth;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LoginResponse {
	private AuthToken token;
	private UserInfo user;
}
