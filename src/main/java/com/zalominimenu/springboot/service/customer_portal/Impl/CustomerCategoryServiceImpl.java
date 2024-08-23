package com.zalominimenu.springboot.service.customer_portal.Impl;

import com.zalominimenu.springboot.dto.customer_portal.requestDTO.CreateCategoryRequest;
import com.zalominimenu.springboot.dto.customer_portal.requestDTO.UpdateCategoryRequest;
import com.zalominimenu.springboot.model.Category;
import com.zalominimenu.springboot.model.Customer;
import com.zalominimenu.springboot.model.Store;
import com.zalominimenu.springboot.repository.customer_portal.CustomerCategoryRepository;
import com.zalominimenu.springboot.repository.customer_portal.CustomerStoreRepository;
import com.zalominimenu.springboot.service.customer_portal.CustomerCategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerCategoryServiceImpl implements CustomerCategoryService {
    private final CustomerCategoryRepository categoryRepository;
    private final CustomerStoreRepository storeRepository;

    @Override
    public Category getCategoryById(Long id) {
        Category existingCategory = categoryRepository.findById(id).get();
        if (existingCategory != null) {
            return existingCategory;
        }
        throw new IllegalStateException("Danh mục không tồn tại");
    }

    @Override
    public Category createCategory(CreateCategoryRequest category) {
        Customer currentCustomer = (Customer) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Store store = storeRepository.findById(category.getStoreId()).orElse(null);
        if (store == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cửa hàng không tồn tại");
        Category newCategory = Category.builder()
                .categoryName(category.getCategoryName())
                .description(category.getDescription())
                .store(store)
                .updatedAt(new Date())
                .updatedBy(currentCustomer.getId())
                .build();

        Category s = categoryRepository.save(newCategory);

        log.info("Thêm danh mục vào cửa hàng thành công {}", s);
        return s;
    }

    @Override
    public Category updateCategory(UpdateCategoryRequest updatedCategory) {
        Customer currentCustomer = (Customer) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Category existingCategory = categoryRepository.findById(updatedCategory.getId()).orElse(null);
        if (existingCategory == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Danh mục không tồn tại");
        }
        existingCategory.setCategoryName(updatedCategory.getCategoryName());
        existingCategory.setDescription(updatedCategory.getDescription());
        existingCategory.setUpdatedBy(currentCustomer.getId());
        existingCategory.setUpdatedAt(new Date());
        return categoryRepository.save(existingCategory);
    }

    @Override
    public Long deleteCategory(Long id) {
        return categoryRepository.deleteCategoryById(id);
    }
}
