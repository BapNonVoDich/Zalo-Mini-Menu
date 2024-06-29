package com.zalominimenu.springboot.dto.admin_portal.auth;

import com.zalominimenu.springboot.enums.AdminRole;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AuthenticatedUserAdminDto {
	private Long id;
	private String name;
	private String username;
	private String email;
	private AdminRole role;
}
