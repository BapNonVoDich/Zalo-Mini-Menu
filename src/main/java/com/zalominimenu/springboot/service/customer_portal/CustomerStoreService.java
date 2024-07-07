package com.zalominimenu.springboot.service.customer_portal;

import com.zalominimenu.springboot.dto.customer_portal.CreateStoreDTO;
import com.zalominimenu.springboot.model.Store;

public interface CustomerStoreService {
	Store createStore(CreateStoreDTO request);
}
