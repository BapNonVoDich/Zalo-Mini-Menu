package com.zalominimenu.springboot.service.admin_portal.Impl;

import com.zalominimenu.springboot.model.AdminUser;
import com.zalominimenu.springboot.repository.admin_portal.AdminUserRepository;
import com.zalominimenu.springboot.service.admin_portal.AdminUserService;
import com.zalominimenu.springboot.service.admin_portal.AdminUserValidationService;
import com.zalominimenu.springboot.utils.GeneralMessageAccessor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class AdminUserServiceImpl implements AdminUserService {

	private static final String REGISTRATION_SUCCESSFUL = "registration_successful";

	private final AdminUserRepository adminUserRepository;

	private final BCryptPasswordEncoder bCryptPasswordEncoder;

	private final AdminUserValidationService userValidationService;

	private final GeneralMessageAccessor generalMessageAccessor;

	@Override
	public Optional<AdminUser> findByUserId(Long id) {
		return adminUserRepository.findById(id);
	}

	@Override
	public AdminUser findByUsername(String username) {
		return adminUserRepository.findByUsername(username);
	}
}
