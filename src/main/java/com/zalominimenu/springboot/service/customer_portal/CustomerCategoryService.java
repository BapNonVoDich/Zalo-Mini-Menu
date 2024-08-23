package com.zalominimenu.springboot.service.customer_portal;

import com.zalominimenu.springboot.dto.customer_portal.requestDTO.CreateCategoryRequest;
import com.zalominimenu.springboot.dto.customer_portal.requestDTO.UpdateCategoryRequest;
import com.zalominimenu.springboot.model.Category;

public interface CustomerCategoryService {


    Category createCategory(CreateCategoryRequest category);

    Category updateCategory(UpdateCategoryRequest updatedCategory);

    Long deleteCategory(Long id);


    Category getCategoryById(Long id);
}
