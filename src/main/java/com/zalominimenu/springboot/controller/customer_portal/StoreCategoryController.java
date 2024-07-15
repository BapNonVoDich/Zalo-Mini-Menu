package com.zalominimenu.springboot.controller.customer_portal;

import com.zalominimenu.springboot.dto.customer_portal.CreateCategoryDTO;
import com.zalominimenu.springboot.model.Category;
import com.zalominimenu.springboot.service.customer_portal.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/customer-portal/category")
public class StoreCategoryController {

    private final CategoryService categoryService;

    @Autowired
    public StoreCategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @GetMapping("store/{storeid}")
    public ResponseEntity<List<Category>> getAllCategoriesByStore(@PathVariable Long storeid) {
        List<Category> Categories = categoryService.getAllCategoriesByStore(storeid);
        return ResponseEntity.ok(Categories);
    }

    @GetMapping()
    public ResponseEntity<List<Category>> getAllCategoriesByStore() {
        List<Category> Categories = categoryService.getAllCategories();
        return ResponseEntity.ok(Categories);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Long id) {
        Category category = categoryService.getCategoryById(id);
        return ResponseEntity.ok(category);
        //return Category.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Category> addCategory(@RequestBody CreateCategoryDTO Category) {
        Category addCategory = categoryService.createCategory(Category);
        return ResponseEntity.ok(addCategory);
    }

    @PutMapping
    public ResponseEntity<Category> updateCategory(@RequestBody Category updatedCategory) {
        // Call the service method to update the Category
        categoryService.updateCategory(updatedCategory);
        return ResponseEntity.ok(updatedCategory);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Category> deleteCategory(@PathVariable Long id) {
        return ResponseEntity.ok(categoryService.deleteCategory(id));
    }
}
