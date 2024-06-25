package com.zalominimenu.springboot.repository;

import com.zalominimenu.springboot.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
