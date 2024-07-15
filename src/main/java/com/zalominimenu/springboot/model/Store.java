package com.zalominimenu.springboot.model;

import com.zalominimenu.springboot.enums.CustomerRole;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
@Table(name = "store")
public class Store extends BaseEntity {
	@Column(name = "name")
	private String name;

	@Column(name = "status")
	private boolean status;

	@Column(name = "address")
	private String address;

	@Column(name = "ward")
	private String ward;

	@Column(name = "district")
	private String district;

	@Column(name = "city")
	private String city;

	@Column(name = "image_path")
	private String imagePath;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "store_manager",
			joinColumns = @JoinColumn(name = "store_id"),
			inverseJoinColumns = @JoinColumn(name = "manager_id"))
	private Set<Customer> managers;
}
