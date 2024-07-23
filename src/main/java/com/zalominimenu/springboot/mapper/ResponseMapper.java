package com.zalominimenu.springboot.mapper;

import com.zalominimenu.springboot.dto.customer_portal.responseDTO.CategoryResponse;
import com.zalominimenu.springboot.dto.customer_portal.responseDTO.ProductResponse;
import com.zalominimenu.springboot.dto.customer_portal.responseDTO.StoreResponse;
import com.zalominimenu.springboot.model.Category;
import com.zalominimenu.springboot.model.Product;
import com.zalominimenu.springboot.model.Store;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ResponseMapper {


    ResponseMapper INSTANCE = Mappers.getMapper(ResponseMapper.class);

    ProductResponse ProductToProductResponse(Product product);

    CategoryResponse CategoryToCategoryResponse(Category category);

    StoreResponse StoreToStoreResponse(Store store);

    List<ProductResponse> ProductsToProductResponses(List<Product> products);

    List<CategoryResponse> CategoriesToCategoryResponses(List<Category> categories);

    List<StoreResponse> StoresToStoreResponses(List<Store> allStores);
}
