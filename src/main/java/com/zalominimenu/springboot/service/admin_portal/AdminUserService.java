package com.zalominimenu.springboot.service.admin_portal;

import com.zalominimenu.springboot.model.AdminUser;

import java.util.Optional;

public interface AdminUserService {
	Optional<AdminUser> findByUserId(Long id);
	AdminUser findByUsername(String username);
}
