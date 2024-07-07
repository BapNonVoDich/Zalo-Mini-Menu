package com.zalominimenu.springboot.model;

import com.zalominimenu.springboot.enums.CustomerRole;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;


@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@SuperBuilder(toBuilder = true)
@Table(name = "customer")
public class Customer extends BaseEntity {
	@Column(name = "name")
	private String name;

	@Column(unique = true, name = "username")
	private String username;

	@Column(name = "email", unique = true)
	private String email;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "role")
	private CustomerRole role;

	@Column(name = "active")
	private boolean active;

	@Column(name = "phone_number")
	private String phoneNumber;
}
