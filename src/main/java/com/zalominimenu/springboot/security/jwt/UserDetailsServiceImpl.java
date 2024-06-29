package com.zalominimenu.springboot.security.jwt;

import com.zalominimenu.springboot.dto.admin_portal.auth.AuthenticatedUserAdminDto;
import com.zalominimenu.springboot.enums.AdminRole;
import com.zalominimenu.springboot.model.AdminUser;
import com.zalominimenu.springboot.service.admin_portal.AdminUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

	private static final String USERNAME_OR_PASSWORD_INVALID = "Invalid username or password.";

	private final AdminUserService adminUserService;

	@Override
	public UserDetails loadUserByUsername(String username) {

		final AdminUser user = adminUserService.findByUsername(username);

		if (Objects.isNull(user)) {
			throw new UsernameNotFoundException(USERNAME_OR_PASSWORD_INVALID);
		}

		final String authenticatedUsername = user.getUsername();
		final String authenticatedPassword = user.getPassword();
		final AdminRole role = user.getRole();
		final SimpleGrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.name());

		return new User(authenticatedUsername, authenticatedPassword, Collections.singletonList(grantedAuthority));
	}
}
