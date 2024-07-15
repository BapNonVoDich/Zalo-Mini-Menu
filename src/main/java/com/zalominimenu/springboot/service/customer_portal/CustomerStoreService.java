package com.zalominimenu.springboot.service.customer_portal;

import com.zalominimenu.springboot.dto.customer_portal.CreateStoreDTO;
import com.zalominimenu.springboot.model.Store;

import java.util.List;

public interface CustomerStoreService {
	Store createStore(CreateStoreDTO request);
	List<Store> getAllStores();

	Store getStoreById(Long id);

	Store updateStore(Store updatedStore);

	Store deleteStore(Long id);
}
