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
        Product existingProduct = getProductById(product.getProduct_id());

        if (existingProduct==null) {
            Product newProduct = Product.builder()
                    .Product_name(product.getProduct_name())
                    .Description(product.getDescription())
                    .Category_code(product.getCategory_code())
                    .Imported_date(product.getImported_date())
                    .End_date(product.getEnd_date())
                    .Start_date(product.getStart_date())
                    .Stock_quantity(product.getStock_quantity())
                    .Store_code(product.getStore_code())
                    .Product_id(product.getProduct_id())
                    .Product_price(product.getProduct_price())
                    .build();
            ;
        }

        return productRepository.save(product);
    }
    @Override
    public void updateProduct(Product product) {
        Product existingProduct = getProductById(product.getProduct_id());
        if (existingProduct!=null) {
            Product newProduct = Product.builder()
                    .Product_name(product.getProduct_name())
                    .Description(product.getDescription())
                    .Category_code(product.getCategory_code())
                    .Imported_date(product.getImported_date())
                    .End_date(product.getEnd_date())
                    .Start_date(product.getStart_date())
                    .Stock_quantity(product.getStock_quantity())
                    .Store_code(product.getStore_code())
                    .Product_id(product.getProduct_id())
                    .Product_price(product.getProduct_price())
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
