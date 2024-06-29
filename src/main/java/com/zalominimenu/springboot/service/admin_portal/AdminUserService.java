package com.zalominimenu.springboot.service.admin_portal;

import com.zalominimenu.springboot.dto.admin_portal.auth.AuthenticatedUserAdminDto;
import com.zalominimenu.springboot.model.AdminUser;

public interface AdminUserService {
	AdminUser findByUsername(String username);
}
