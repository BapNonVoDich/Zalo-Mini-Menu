package com.zalominimenu.springboot.repository;

import com.zalominimenu.springboot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

// rimmel asghar
public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername(String username);

	boolean existsByEmail(String email);

	boolean existsByUsername(String username);

}
