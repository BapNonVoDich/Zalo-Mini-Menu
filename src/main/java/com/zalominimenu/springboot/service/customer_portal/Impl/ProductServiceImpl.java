package com.zalominimenu.springboot.service.customer_portal.Impl;
import com.zalominimenu.springboot.dto.customer_portal.CreateProductDTO;
import com.zalominimenu.springboot.model.Product;
import com.zalominimenu.springboot.repository.customer_portal.CustomerStoreRepository;
import com.zalominimenu.springboot.repository.customer_portal.ProductRepository;
import com.zalominimenu.springboot.service.customer_portal.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final CustomerStoreRepository storeRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }


    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).get();
    }

    @Override
    public List<Product> getProductsByCategory(Long category) {
        return productRepository.findAllByCategoryId(category);
    }

    @Override
    public List<Product> getProductsByStore(Long id) {
        return productRepository.findAllByStoreId(id);
    }

    @Override
    public Product createProduct(CreateProductDTO product) {
            Product newProduct = Product.builder()
                    .description(product.getDescription())
                    .stockQuantity(product.getStockQuantity())
                    .store(storeRepository.findById(product.getStoreId()).get())
                    .productName(product.getProductName())
                    .productPrice(product.getProductPrice())
                    .build();
        return productRepository.save(newProduct);
    }
    @Override
    public Product updateProduct(Product product) {
        Product existingProduct = productRepository.findById(product.getId()).get();
        if (existingProduct!=null) {
            Product newProduct = Product.builder()
                    .id(existingProduct.getId())
                    .productName(product.getProductName())
                    .description(product.getDescription())
                    .category(product.getCategory())
                    .stockQuantity(product.getStockQuantity())
                    .store(product.getStore())
                    .productPrice(product.getProductPrice())
                    .createdAt(existingProduct.getCreatedAt())
                    .imagePath(existingProduct.getImagePath())
                    .updatedAt(new Date())
                    .build();
            return productRepository.save(newProduct);
        }
        return null;


    }
    @Override
    public Product deleteProduct(Long id) {
        Product existingProduct = productRepository.findById(id).get();
        if (existingProduct!=null) {
            return existingProduct;
        }
        return null;
    }
}
