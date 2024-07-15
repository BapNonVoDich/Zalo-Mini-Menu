package com.zalominimenu.springboot.controller.customer_portal;

import com.zalominimenu.springboot.dto.customer_portal.CreateProductDTO;
import com.zalominimenu.springboot.model.Product;
import com.zalominimenu.springboot.service.customer_portal.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/customer-portal/product/")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> Products = productService.getAllProducts();
        return ResponseEntity.ok(Products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Product product = productService.getProductById(id);
        return ResponseEntity.ok(product);
        //return Product.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("category/{id}")
    public ResponseEntity<List<Product>> getProductByCategoryId(@PathVariable Long id) {
        List<Product> product = productService.getProductsByCategory(id);
        return ResponseEntity.ok(product);
        //return Product.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Product> addProduct(@Valid @RequestBody CreateProductDTO Product) {
        Product addProduct = productService.createProduct(Product);
        return ResponseEntity.ok(addProduct);
    }

    @PutMapping
    public ResponseEntity<Product> updateProduct(@RequestBody Product updatedProduct) {
        // Call the service method to update the Product
        productService.updateProduct(updatedProduct);
            return ResponseEntity.ok(updatedProduct);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable Long id) {
        Product deletedProduct= productService.deleteProduct(id);
        return ResponseEntity.ok(deletedProduct);
    }

    //unfinished
    @GetMapping("store/{id}")
    public ResponseEntity<List<Product>> getProductsByStore(@PathVariable Long id) {
        List<Product> product = productService.getProductsByStore(id);
        return ResponseEntity.ok(product);
    }
}
