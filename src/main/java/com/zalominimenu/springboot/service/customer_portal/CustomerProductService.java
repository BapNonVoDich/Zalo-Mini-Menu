package com.zalominimenu.springboot.service.customer_portal;

import com.zalominimenu.springboot.dto.customer_portal.requestDTO.CreateProductDTO;
import com.zalominimenu.springboot.dto.customer_portal.requestDTO.UpdateProductDTO;
import com.zalominimenu.springboot.model.Product;

import java.util.List;

public interface CustomerProductService {

    List<Product> getAllProducts();

    Product getProductById(Long id);

    Product createProduct(CreateProductDTO Product);

    Long deleteProduct(Long id);

    Product updateProduct(UpdateProductDTO product);


}
