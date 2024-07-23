package com.zalominimenu.springboot.service.customer_portal;

import com.zalominimenu.springboot.dto.customer_portal.requestDTO.ProductDTO;
import com.zalominimenu.springboot.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();

    Product getProductById(Long id);

    Product createProduct(ProductDTO Product, Long storeId);

    Product deleteProduct(Long id);

    Product updateProduct(ProductDTO product, Long productId);

    List<Product> getProductsByCategory(Long id);

    List<Product> getProductsByStore(Long id);

    List<Product> getProductsByCategories(List<Long> ids);
}
