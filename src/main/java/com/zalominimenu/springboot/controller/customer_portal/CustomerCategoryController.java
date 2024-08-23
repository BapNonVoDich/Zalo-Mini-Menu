package com.zalominimenu.springboot.controller.customer_portal;

import com.zalominimenu.springboot.dto.BaseResponse;
import com.zalominimenu.springboot.dto.customer_portal.requestDTO.CreateCategoryRequest;
import com.zalominimenu.springboot.dto.customer_portal.requestDTO.UpdateCategoryRequest;
import com.zalominimenu.springboot.dto.customer_portal.responseDTO.CategoryResponse;
import com.zalominimenu.springboot.mapper.CategoryMapper;
import com.zalominimenu.springboot.service.customer_portal.CustomerCategoryService;
import com.zalominimenu.springboot.utils.CustomResponseEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@Slf4j
@RequestMapping("/v1/customer-portal/category/")
public class CustomerCategoryController {

    private final CustomerCategoryService categoryService;


    @GetMapping("{id}")
    public ResponseEntity<BaseResponse<CategoryResponse>> getCategoryById(@PathVariable Long id) {
        final CategoryResponse category = CategoryMapper.INSTANCE.CategoryToCategoryResponse(categoryService.getCategoryById(id));
        return CustomResponseEntity.ok(category, "Trả về danh mục thành công");
    }

    @PostMapping()
    public ResponseEntity<BaseResponse<CategoryResponse>> createCategory(@RequestBody CreateCategoryRequest Category) {
        final CategoryResponse addCategory = CategoryMapper.INSTANCE.CategoryToCategoryResponse(categoryService.createCategory(Category));
        return CustomResponseEntity.ok(addCategory, "Thêm danh mục vào cửa hàng thành công");
    }

    @PutMapping
    public ResponseEntity<BaseResponse<CategoryResponse>> updateCategory(@RequestBody UpdateCategoryRequest category) {
        final CategoryResponse updatedCategory = CategoryMapper.INSTANCE.CategoryToCategoryResponse(categoryService.updateCategory(category));
        return CustomResponseEntity.ok(updatedCategory, "Cập nhật danh mục thành công");
    }

    @DeleteMapping("{id}")
    public ResponseEntity<BaseResponse<Long>> deleteCategory(@PathVariable Long id) {
        final Long deletedCategory = categoryService.deleteCategory(id);
        return CustomResponseEntity.ok(deletedCategory, "Xoá danh mục thành công");
    }
}
