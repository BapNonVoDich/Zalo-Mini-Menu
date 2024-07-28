package com.zalominimenu.springboot.mapper;

import com.zalominimenu.springboot.dto.customer_portal.responseDTO.CategoryResponse;
import com.zalominimenu.springboot.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CategoryMapper {
    CategoryResponse CategoryToCategoryResponse(Category category);
    List<CategoryResponse> CategoriesToCategoryResponses(List<Category> categories);
}
