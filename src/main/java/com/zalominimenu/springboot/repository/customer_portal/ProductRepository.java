package com.zalominimenu.springboot.repository.customer_portal;

import com.zalominimenu.springboot.model.Category;
import com.zalominimenu.springboot.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByCategoryId(Long category);

    List<Product> findAllByStoreId(Long id);

    List<Product> findAllByCategoryIdIn(List<Long> ids);

}
