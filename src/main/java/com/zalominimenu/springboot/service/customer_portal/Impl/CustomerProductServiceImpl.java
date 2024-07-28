package com.zalominimenu.springboot.service.customer_portal.Impl;

import com.zalominimenu.springboot.dto.customer_portal.requestDTO.CreateProductDTO;
import com.zalominimenu.springboot.dto.customer_portal.requestDTO.UpdateProductDTO;
import com.zalominimenu.springboot.model.Category;
import com.zalominimenu.springboot.model.Customer;
import com.zalominimenu.springboot.model.Product;
import com.zalominimenu.springboot.model.Store;
import com.zalominimenu.springboot.repository.customer_portal.CustomerCategoryRepository;
import com.zalominimenu.springboot.repository.customer_portal.CustomerStoreRepository;
import com.zalominimenu.springboot.repository.customer_portal.CustomerProductRepository;
import com.zalominimenu.springboot.service.customer_portal.CustomerProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerProductServiceImpl implements CustomerProductService {
    private final CustomerProductRepository productRepository;
    private final CustomerStoreRepository storeRepository;
    private final CustomerCategoryRepository categoryRepository;

    @Override
    public List<Product> getAllProducts() {
        List<Product> products = productRepository.findAll();
        if (products!=null){
            return products;
        }
        throw new IllegalStateException("Danh sách cửa hàng trống!");
    }


    @Override
    public Product getProductById(Long id) {
        Product product = productRepository.findById(id).get();
        if (product!=null){
            return product;
        }
        throw new IllegalStateException("Cửa hàng không tồn tại!");
    }


    @Override
    public Product createProduct(CreateProductDTO product) {
            Customer currentCustomer = (Customer) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            Store store = storeRepository.findById(product.getStoreId()).get();
            Set<Category> categories = categoryRepository.findByIdIn(product.getCategoryIds());
            if (categories==null||store==null) throw new IllegalStateException("Danh mục hoăc cửa hàng không tồn tại");
            final Product newProduct = Product.builder()
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
    public Product updateProduct(UpdateProductDTO product) {
        Customer currentCustomer = (Customer) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Product existingProduct = productRepository.findById(product.getId()).get();
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
        throw new IllegalStateException("Sản phẩm không tồn tại");

    }
    @Override
    public Long deleteProduct(Long id) {
        return productRepository.deleteProductById(id);
    }
}
