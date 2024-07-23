package com.zalominimenu.springboot.service.customer_portal.Impl;
import com.zalominimenu.springboot.dto.customer_portal.requestDTO.ProductDTO;
import com.zalominimenu.springboot.model.Category;
import com.zalominimenu.springboot.model.Customer;
import com.zalominimenu.springboot.model.Product;
import com.zalominimenu.springboot.model.Store;
import com.zalominimenu.springboot.repository.customer_portal.CategoryRepository;
import com.zalominimenu.springboot.repository.customer_portal.CustomerStoreRepository;
import com.zalominimenu.springboot.repository.customer_portal.ProductRepository;
import com.zalominimenu.springboot.service.customer_portal.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final CustomerStoreRepository storeRepository;
    private final CategoryRepository categoryRepository;

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
    public List<Product> getProductsByCategories(List<Long> ids) {
        return productRepository.findAllByCategoryIdIn(ids);
    }

    @Override
    public Product createProduct(ProductDTO product, Long storeId) {
            Customer currentCustomer = (Customer) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            Store store = storeRepository.findById(storeId).get();
            Set<Category> categories = categoryRepository.findByIdIn(product.getCategoryIds());
            Product newProduct = Product.builder()
                    .description(product.getDescription())
                    .stockQuantity(product.getStockQuantity())
                    .store(store)
                    .category(categories)
                    .productName(product.getProductName())
                    .productPrice(product.getProductPrice())
                    .imageURL("src/main/resources/image/product")
                    .updatedBy(currentCustomer.getId())
                    .build();
        return productRepository.save(newProduct);
    }
    @Override
    public Product updateProduct(ProductDTO product, Long productId) {
        Customer currentCustomer = (Customer) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Product existingProduct = productRepository.findById(productId).get();
        Set<Category> categories = categoryRepository.findByIdIn(product.getCategoryIds());
        if (existingProduct!=null) {
            existingProduct.setProductPrice(product.getProductPrice());
            existingProduct.setProductName(product.getProductName());
            existingProduct.setDescription(product.getDescription());
            existingProduct.setStockQuantity(product.getStockQuantity());
            existingProduct.setCategory(categories);
            existingProduct.setUpdatedAt(new Date());
            existingProduct.setUpdatedBy(currentCustomer.getId());
            return productRepository.save(existingProduct);
        }
        throw new IllegalStateException("product does not exist");

    }
    @Override
    public Product deleteProduct(Long id) {
        Product existingProduct = productRepository.findById(id).get();
        if (existingProduct!=null) {
            productRepository.delete(existingProduct);
            return existingProduct;
        }
        throw new IllegalStateException("product does not exist");
    }
}
