package com.zalominimenu.springboot.repository.customer_portal;

import com.zalominimenu.springboot.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByCategoryId(Long category);

    List<Product> findAllByStoreId(Long id);
}
