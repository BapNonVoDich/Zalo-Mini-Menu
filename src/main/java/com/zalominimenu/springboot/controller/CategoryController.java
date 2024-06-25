package com.zalominimenu.springboot.controller;

import com.zalominimenu.springboot.model.Category;
import com.zalominimenu.springboot.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<List<Category>> getAllCategorys() {
        List<Category> Categorys = categoryService.getAllCategorys();
        return ResponseEntity.ok(Categorys);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Long id) {
        Category category = categoryService.getCategoryById(id);
        return ResponseEntity.ok(category);
        //return Category.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Category> addCategory(@RequestBody Category Category) {
        Category addCategory = categoryService.saveCategory(Category);
        return ResponseEntity.ok(addCategory);
    }

    @PutMapping
    public ResponseEntity<Category> updateCategory(@RequestBody Category updatedCategory) {
        // Call the service method to update the Category
        categoryService.updateCategory(updatedCategory);
        return ResponseEntity.ok(updatedCategory);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }
}
