package com.zalominimenu.springboot.mapper;

import com.zalominimenu.springboot.dto.customer_portal.responseDTO.StoreResponse;
import com.zalominimenu.springboot.model.Store;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface StoreMapper {
    StoreResponse StoreToStoreResponse(Store store);


    List<StoreResponse> StoresToStoreResponses(List<Store> allStores);

}
