package com.zalominimenu.springboot.security.jwt;

import com.zalominimenu.springboot.mapper.AdminUserMapper;
import com.zalominimenu.springboot.mapper.CustomerMapper;
import com.zalominimenu.springboot.model.AdminUser;
import com.zalominimenu.springboot.model.Customer;
import com.zalominimenu.springboot.repository.customer_portal.CustomerRepository;
import com.zalominimenu.springboot.service.admin_portal.AdminUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Objects;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl {

	private static final String USERNAME_OR_PASSWORD_INVALID = "Invalid username or password.";

	private final AdminUserService adminUserService;

	private final CustomerRepository customerRepository;
	public CustomUserDetails loadUserAdminById(Long userId) {

		final Optional<AdminUser> user = adminUserService.findByUserId(userId);

		if (user.isEmpty()) {
			throw new UsernameNotFoundException(USERNAME_OR_PASSWORD_INVALID);
		}
		final CustomUserDetails userInfo = AdminUserMapper.INSTANCE.convertToCustomUserDetails(user.get());

		final SimpleGrantedAuthority grantedAuthority = new SimpleGrantedAuthority(user.get().getRole().toString());
		userInfo.setAuthorities(Collections.singletonList(grantedAuthority));
		return userInfo;
	}

	public CustomUserDetails loadCustomerById(Long userId) {
		final Customer user = customerRepository.findCustomerById(userId);
		if (Objects.isNull(user)) {
			throw new UsernameNotFoundException(USERNAME_OR_PASSWORD_INVALID);
		}
		final CustomUserDetails userInfo = CustomerMapper.INSTANCE.convertToCustomUserDetails(user);

		final SimpleGrantedAuthority grantedAuthority = new SimpleGrantedAuthority(user.getRole().toString());
		userInfo.setAuthorities(Collections.singletonList(grantedAuthority));
		return userInfo;
	}
}
