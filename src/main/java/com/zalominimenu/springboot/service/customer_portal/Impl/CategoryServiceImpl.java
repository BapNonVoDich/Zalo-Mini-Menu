package com.zalominimenu.springboot.service.customer_portal.Impl;

import com.zalominimenu.springboot.dto.customer_portal.requestDTO.CategoryDTO;
import com.zalominimenu.springboot.model.Category;
import com.zalominimenu.springboot.model.Customer;
import com.zalominimenu.springboot.model.Store;
import com.zalominimenu.springboot.repository.customer_portal.CategoryRepository;
import com.zalominimenu.springboot.repository.customer_portal.CustomerStoreRepository;
import com.zalominimenu.springboot.service.customer_portal.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
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
    public Category createCategory(CategoryDTO category, Long storeId) {
        Customer currentCustomer = (Customer) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Store store = storeRepository.findById(storeId).get();
        Category newCategory = Category.builder()
                .categoryName(category.getCategoryName())
                .description(category.getDescription())
                .store(store)
                .updatedAt(new Date())
                .updatedBy(currentCustomer.getId())
                .build();

        return categoryRepository.save(newCategory);
    }

    @Override
    public Category updateCategory(Category updatedCategory) {
        Customer currentCustomer = (Customer) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Category existingCategory = categoryRepository.findById(updatedCategory.getId()).get();
        if (existingCategory!=null) {
            existingCategory.setCategoryName(updatedCategory.getCategoryName());
            existingCategory.setDescription(updatedCategory.getDescription());
            existingCategory.setUpdatedBy(currentCustomer.getId());
            existingCategory.setUpdatedAt(new Date());
            return categoryRepository.save(existingCategory);
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
