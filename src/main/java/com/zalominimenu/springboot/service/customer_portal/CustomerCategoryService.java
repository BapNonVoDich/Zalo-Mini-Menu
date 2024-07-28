package com.zalominimenu.springboot.service.customer_portal;

import com.zalominimenu.springboot.dto.customer_portal.requestDTO.CreateCategoryDTO;
import com.zalominimenu.springboot.dto.customer_portal.requestDTO.UpdateCategoryDTO;
import com.zalominimenu.springboot.model.Category;

public interface CustomerCategoryService {


    Category createCategory(CreateCategoryDTO category);

    Category updateCategory(UpdateCategoryDTO updatedCategory);

    Long deleteCategory(Long id);



    Category getCategoryById(Long id);
}
