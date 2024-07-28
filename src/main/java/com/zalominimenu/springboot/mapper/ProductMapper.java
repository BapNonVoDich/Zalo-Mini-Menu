package com.zalominimenu.springboot.mapper;

import com.zalominimenu.springboot.dto.customer_portal.responseDTO.ProductResponse;
import com.zalominimenu.springboot.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)

public interface ProductMapper {
    ProductResponse ProductToProductResponse(Product product);
    List<ProductResponse> ProductsToProductResponses(List<Product> products);
}
