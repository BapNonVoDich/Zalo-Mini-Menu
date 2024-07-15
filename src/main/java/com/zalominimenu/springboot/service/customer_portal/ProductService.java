package com.zalominimenu.springboot.service.customer_portal;

import com.zalominimenu.springboot.dto.customer_portal.CreateProductDTO;
import com.zalominimenu.springboot.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();

    Product getProductById(Long id);

    Product createProduct(CreateProductDTO Product);

    Product deleteProduct(Long id);

    Product updateProduct(Product Product);

    List<Product> getProductsByCategory(Long id);

    List<Product> getProductsByStore(Long id);
}
