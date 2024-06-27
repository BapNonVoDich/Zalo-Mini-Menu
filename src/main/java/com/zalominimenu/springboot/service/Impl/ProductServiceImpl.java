package com.zalominimenu.springboot.service.Impl;
import com.zalominimenu.springboot.model.Product;
import com.zalominimenu.springboot.repository.ProductRepository;
import com.zalominimenu.springboot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).get();
    }

    @Override
    public Product saveProduct(Product product) {
        Product existingProduct = getProductById(product.getId());

        if (existingProduct==null) {
            Product newProduct = Product.builder()
                    .name(product.getName())
                    .description(product.getDescription())
                    .categoryId(product.getCategoryId())
                    .price(product.getPrice())
                    .stock(product.getStock())
                    .startDate(product.getStartDate())
                    .endDate(product.getEndDate())
                    .importedDate(product.getImportedDate())
                    .storeId(product.getStoreId())
                    .imageUrl(product.getImageUrl())
                    .build();
        }

        return productRepository.save(product);
    }
    @Override
    public void updateProduct(Product product) {
        Product existingProduct = getProductById(product.getId());
        if (existingProduct!=null) {
            Product newProduct = Product.builder()
                    .name(product.getName())
                    .description(product.getDescription())
                    .categoryId(product.getCategoryId())
                    .price(product.getPrice())
                    .stock(product.getStock())
                    .startDate(product.getStartDate())
                    .endDate(product.getEndDate())
                    .importedDate(product.getImportedDate())
                    .storeId(product.getStoreId())
                    .imageUrl(product.getImageUrl())
                    .build();
            ;
        }
        productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
