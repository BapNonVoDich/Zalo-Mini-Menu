package com.zalominimenu.springboot.service.customer_portal;

import com.zalominimenu.springboot.dto.customer_portal.CreateCategoryDTO;
import com.zalominimenu.springboot.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();

    Category getCategoryById(Long id);

    Category createCategory(CreateCategoryDTO category);

    Category updateCategory(Category updatedCategory);

    Category deleteCategory(Long id);

    List<Category> getAllCategoriesByStore(Long storeid);
}
