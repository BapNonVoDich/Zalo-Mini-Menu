package com.zalominimenu.springboot.repository.customer_portal;

import com.zalominimenu.springboot.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerProductRepository extends PagingAndSortingRepository<Product, Long>, JpaSpecificationExecutor<Product>, JpaRepository<Product, Long> {
    List<Product> findAllByCategoryId(Long category);

    List<Product> findAllByStoreId(Long id);

    List<Product> findAllByCategoryIdIn(List<Long> ids);

    Long deleteProductById(Long id);
}
