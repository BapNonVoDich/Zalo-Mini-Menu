package com.zalominimenu.springboot.service.customer_portal;

import com.zalominimenu.springboot.dto.customer_portal.requestDTO.CreateProductRequest;
import com.zalominimenu.springboot.dto.customer_portal.requestDTO.ListProductRequest;
import com.zalominimenu.springboot.dto.customer_portal.requestDTO.UpdateProductRequest;
import com.zalominimenu.springboot.model.Product;
import lombok.NonNull;
import org.springframework.data.domain.Page;

public interface CustomerProductService {

    Page<Product> getListProducts(@NonNull ListProductRequest request);

    Product getProductById(Long id);

    Product createProduct(CreateProductRequest Product);

    Long deleteProduct(Long id);

    Product updateProduct(UpdateProductRequest product);
}
