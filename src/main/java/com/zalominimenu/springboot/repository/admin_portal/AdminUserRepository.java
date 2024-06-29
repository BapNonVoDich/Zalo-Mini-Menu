package com.zalominimenu.springboot.repository.admin_portal;

import com.zalominimenu.springboot.model.AdminUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminUserRepository extends JpaRepository<AdminUser, Long> {

	AdminUser findByUsername(String username);

	boolean existsByEmail(String email);

	boolean existsByUsername(String username);
}
