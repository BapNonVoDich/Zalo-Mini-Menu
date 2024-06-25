package com.zalominimenu.springboot.service;

import com.zalominimenu.springboot.model.Store;

import java.util.List;

public interface StoreService {
    List<Store> getAllStores();

    Store getStoreById(Long id);

    Store saveStore(Store Store);

    void deleteStore(Long id);

    void updateStore(Store store);
}
