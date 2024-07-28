package com.zalominimenu.springboot.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
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

	@Column(name = "image_url")
	private String imageURL;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "store_manager",
			joinColumns = @JoinColumn(name = "store_id"),
			inverseJoinColumns = @JoinColumn(name = "manager_id"))
	private Set<Customer> managers;
}
