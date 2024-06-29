package com.zalominimenu.springboot.model;

import com.zalominimenu.springboot.enums.AdminRole;
import lombok.*;

import javax.persistence.*;

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

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "role")
	private AdminRole role;
}
