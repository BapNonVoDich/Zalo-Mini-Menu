package com.zalominimenu.springboot.repository.customer_portal;

import com.zalominimenu.springboot.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findAllByStoreId(Long storeid);
}
