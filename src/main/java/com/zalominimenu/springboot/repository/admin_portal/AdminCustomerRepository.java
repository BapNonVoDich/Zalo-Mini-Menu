package com.zalominimenu.springboot.repository.admin_portal;

import com.zalominimenu.springboot.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminCustomerRepository extends JpaRepository<Customer, Long> {

	Customer findByUsername(String username);

	boolean existsByEmail(String email);

	boolean existsByUsername(String username);
}
