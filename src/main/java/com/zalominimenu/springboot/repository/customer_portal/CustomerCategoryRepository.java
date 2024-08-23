package com.zalominimenu.springboot.repository.customer_portal;

import com.zalominimenu.springboot.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface CustomerCategoryRepository extends JpaRepository<Category, Long> {

    Set<Category> findByIdIn(Set<Long> categories);
    @Modifying
    Long deleteCategoryById(Long id);
}
