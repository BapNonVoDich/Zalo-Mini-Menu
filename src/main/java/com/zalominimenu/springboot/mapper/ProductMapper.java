package com.zalominimenu.springboot.mapper;

import com.zalominimenu.springboot.dto.customer_portal.responseDTO.ProductResponse;
import com.zalominimenu.springboot.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;

@Mapper
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductResponse ProductToProductResponse(Product product);

    default Page<ProductResponse> ProductsToProductResponses(Page<Product> products) {
        return products.map(this::ProductToProductResponse);
    }
}
