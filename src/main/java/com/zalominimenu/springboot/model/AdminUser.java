package com.zalominimenu.springboot.model;

import com.zalominimenu.springboot.enums.AdminRole;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;


@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@ToString(callSuper = true)
@Table(name = "admin_user")
public class AdminUser extends BaseEntity {
	@Column(name = "name")
	private String name;

	@Column(unique = true, name = "username")
	private String username;

	@Column(name = "password")
	private String password;

	@Column(name = "email", unique = true)
	private String email;

	@Enumerated()
	@Column(name = "role", columnDefinition = "smallint")
	private AdminRole role;

	@Column(name = "active")
	private boolean active;
}
