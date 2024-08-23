package com.zalominimenu.springboot.service.customer_portal;

import com.zalominimenu.springboot.dto.customer_portal.requestDTO.CreateStoreRequest;
import com.zalominimenu.springboot.dto.customer_portal.requestDTO.UpdateStoreRequest;
import com.zalominimenu.springboot.model.Store;

import java.util.List;

public interface CustomerStoreService {
    Store createStore(CreateStoreRequest request);

    List<Store> getAllStores();

    Store getStoreById(Long id);

    Store updateStore(UpdateStoreRequest updatedStore);

    Long deleteStore(Long id);
}
