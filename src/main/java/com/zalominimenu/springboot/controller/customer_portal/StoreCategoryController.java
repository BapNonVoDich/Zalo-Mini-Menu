package com.zalominimenu.springboot.controller.customer_portal;

import com.zalominimenu.springboot.dto.BaseResponse;
import com.zalominimenu.springboot.dto.customer_portal.requestDTO.CategoryDTO;
import com.zalominimenu.springboot.dto.customer_portal.responseDTO.CategoryResponse;
import com.zalominimenu.springboot.mapper.ResponseMapper;
import com.zalominimenu.springboot.model.Category;
import com.zalominimenu.springboot.service.customer_portal.CategoryService;
import com.zalominimenu.springboot.utils.CustomResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/customer-portal/category/")
public class StoreCategoryController {

    private final CategoryService categoryService;

    @Autowired
    private ResponseMapper responseMapper;
    @Autowired
    public StoreCategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @GetMapping("store/{storeid}")
    public ResponseEntity<BaseResponse<List<CategoryResponse>>> getAllCategoriesByStore(@PathVariable Long storeid) {
        List<CategoryResponse> Categories = responseMapper.CategoriesToCategoryResponses(categoryService.getAllCategoriesByStore(storeid));
        return CustomResponseEntity.ok(Categories,"Trả về danh mục theo cửa hàng thành công");
    }

    @GetMapping()
    public ResponseEntity<BaseResponse<List<CategoryResponse>>> getAllCategories() {
        List<CategoryResponse> Categories = responseMapper.CategoriesToCategoryResponses(categoryService.getAllCategories());
        return CustomResponseEntity.ok(Categories,"Trả về tất cả cửa hàng thành công");
    }

    @GetMapping("{id}")
    public ResponseEntity<BaseResponse<CategoryResponse>> getCategoryById(@PathVariable Long id) {
        final CategoryResponse category = responseMapper.CategoryToCategoryResponse(categoryService.getCategoryById(id));
        return CustomResponseEntity.ok(category,"Trả về danh mục thành công");
    }

    @PostMapping("store/{storeId}")
    public ResponseEntity<BaseResponse<CategoryResponse>> addCategory(@RequestBody CategoryDTO Category, @PathVariable Long storeId) {
        final CategoryResponse addCategory = responseMapper.CategoryToCategoryResponse(categoryService.createCategory(Category, storeId));
        return CustomResponseEntity.ok(addCategory,"Thêm danh mục vào cửa hàng thành công");
    }

    @PutMapping
    public ResponseEntity<BaseResponse<CategoryResponse>> updateCategory(@RequestBody Category category) {
        final CategoryResponse updatedCategory = responseMapper.CategoryToCategoryResponse(categoryService.updateCategory(category));
        return CustomResponseEntity.ok(updatedCategory,"Cập nhật danh mục thành công");
    }

    @DeleteMapping("{id}")
    public ResponseEntity<BaseResponse<CategoryResponse>> deleteCategory(@PathVariable Long id) {
        final CategoryResponse deletedCategory = responseMapper.CategoryToCategoryResponse(categoryService.deleteCategory(id));
        return CustomResponseEntity.ok(deletedCategory,"Xoá danh mục thành công");
    }
}
