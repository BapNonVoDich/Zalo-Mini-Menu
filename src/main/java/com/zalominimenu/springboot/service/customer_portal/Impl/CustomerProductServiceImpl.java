package com.zalominimenu.springboot.service.customer_portal.Impl;

import com.zalominimenu.springboot.dto.customer_portal.requestDTO.CreateProductRequest;
import com.zalominimenu.springboot.dto.customer_portal.requestDTO.ListProductRequest;
import com.zalominimenu.springboot.dto.customer_portal.requestDTO.UpdateProductRequest;
import com.zalominimenu.springboot.model.Category;
import com.zalominimenu.springboot.model.Customer;
import com.zalominimenu.springboot.model.Product;
import com.zalominimenu.springboot.model.Store;
import com.zalominimenu.springboot.repository.customer_portal.CustomerCategoryRepository;
import com.zalominimenu.springboot.repository.customer_portal.CustomerProductRepository;
import com.zalominimenu.springboot.repository.customer_portal.CustomerStoreRepository;
import com.zalominimenu.springboot.service.customer_portal.CustomerProductService;
import com.zalominimenu.springboot.specification.customer_portal.ProductSearchSpecification;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerProductServiceImpl implements CustomerProductService {
    private final CustomerProductRepository productRepository;
    private final CustomerStoreRepository storeRepository;
    private final CustomerCategoryRepository categoryRepository;

    @Override
    public Page<Product> getListProducts(@NonNull ListProductRequest request) {
        return productRepository.findAll(ProductSearchSpecification.findByCriteria(request), request.buildPageable());
    }

    @Override
    public Product getProductById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Không tìm thấy sản phẩm");
        return product.get();
    }


    @Override
    public Product createProduct(CreateProductRequest productDTO) {
        Customer currentCustomer = (Customer) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Optional<Store> store = storeRepository.findById(productDTO.getStoreId());
        Set<Category> categories = categoryRepository.findByIdIn(productDTO.getCategoryIds());
        if (categories.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Danh mục không tồn tại");
        }

        if (store.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cửa hàng không tồn tại");
        }

        final Product newProduct = Product.builder()
                .description(productDTO.getDescription())
                .stockQuantity(productDTO.getStockQuantity())
                .store(store.get())
                .category(categories)
                .productName(productDTO.getProductName())
                .productPrice(productDTO.getProductPrice())
                .imageURL(productDTO.getImageURL())
                .updatedBy(currentCustomer.getId())
                .build();
        return productRepository.save(newProduct);
    }

    @Override
    public Product updateProduct(UpdateProductRequest updateProductRequest) {
        Customer currentCustomer = (Customer) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Optional<Product> optionalProduct = productRepository.findById(updateProductRequest.getId());
        if (optionalProduct.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Không tìm thấy sản phẩm");
        }

        Product product = optionalProduct.get();

        Set<Category> categories = categoryRepository.findByIdIn(updateProductRequest.getCategoryIds());
        if (categories.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Danh mục không tồn tại");
        }
        Store store = storeRepository.findById(updateProductRequest.getStoreId()).orElse(null);
        if (store == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cửa hàng không tồn tại");
        }
        product.setProductPrice(updateProductRequest.getProductPrice());
        product.setProductName(updateProductRequest.getProductName());
        product.setDescription(updateProductRequest.getDescription());
        product.setStockQuantity(updateProductRequest.getStockQuantity());
        product.setCategory(categories);
        product.setStore(store);
        product.setImageURL(updateProductRequest.getImageURL());
        product.setUpdatedAt(new Date());
        product.setUpdatedBy(currentCustomer.getId());
        return productRepository.save(product);
    }

    @Override
    public Long deleteProduct(Long id) {
        Long eff = productRepository.deleteProductById(id);
        if (eff == 0) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Không tìm thấy sản phẩm");
        }
        return eff;
    }
}
