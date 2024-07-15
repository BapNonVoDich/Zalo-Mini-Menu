package com.zalominimenu.springboot.service.customer_portal.Impl;

import com.zalominimenu.springboot.dto.customer_portal.CreateCategoryDTO;
import com.zalominimenu.springboot.model.Category;
import com.zalominimenu.springboot.model.Store;
import com.zalominimenu.springboot.repository.customer_portal.CategoryRepository;
import com.zalominimenu.springboot.repository.customer_portal.CustomerStoreRepository;
import com.zalominimenu.springboot.service.customer_portal.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Slf4j
@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final CustomerStoreRepository storeRepository;
    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }


    @Override
    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).get();
    }

    @Override
    public Category createCategory(CreateCategoryDTO category) {
        Store store = storeRepository.findById(category.getStoreId()).get();
        Category newCategory = Category.builder()
                .categoryName(category.getCategoryName())
                .description(category.getDescription())
                .store(store)
                .build();

        return categoryRepository.save(newCategory);
    }

    @Override
    public Category updateCategory(Category updatedCategory) {
        Category existingCategory = categoryRepository.findById(updatedCategory.getId()).get();
        if (existingCategory!=null) {
            Category newCategory = Category.builder()
                    .id(existingCategory.getId())
                    .categoryName(updatedCategory.getCategoryName())
                    .description(updatedCategory.getDescription())
                    .createdAt(existingCategory.getCreatedAt())
                    .updatedAt(new Date())
                    .build();
            return categoryRepository.save(newCategory);
        }
        return null;
    }

    @Override
    public Category deleteCategory(Long id) {
        Category existingCategory = categoryRepository.findById(id).get();
        if (existingCategory!=null) {
            categoryRepository.delete(existingCategory);
            return existingCategory;
        }
        return null;
    }

    @Override
    public List<Category> getAllCategoriesByStore(Long storeid) {
        return categoryRepository.findAllByStoreId(storeid);
    }
}
