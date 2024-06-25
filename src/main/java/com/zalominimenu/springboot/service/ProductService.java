package com.zalominimenu.springboot.service;
import com.zalominimenu.springboot.model.Product;
import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> getAllProducts();

    Product getProductById(Long id);

    Product saveProduct(Product Product);

    void deleteProduct(Long id);

    void updateProduct(Product Product);
}
