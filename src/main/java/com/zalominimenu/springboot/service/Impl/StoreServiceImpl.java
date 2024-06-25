package com.zalominimenu.springboot.service.Impl;

import com.zalominimenu.springboot.model.Store;
import com.zalominimenu.springboot.repository.StoreRepository;
import com.zalominimenu.springboot.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class StoreServiceImpl implements StoreService {
    private final StoreRepository storeRepository;

    @Autowired
    public StoreServiceImpl(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    @Override
    public List<Store> getAllStores() {
        return storeRepository.findAll();
    }

    @Override
    public Store getStoreById(Long id) {
        return storeRepository.findById(id).get();
    }

    @Override
    public Store saveStore(Store store) {
        Store existingStore = getStoreById(store.getStore_id());

//        if (existingStore==null) {
//            Store newStore = Store.builder()
//                    .Store_name(store.getStore_name())
//                    .Address(store.getAddress())
//                    .Address_city(store.getAddress_city())
//                    .Address_district(store.getAddress_district())
//                    .Address_ward(store.getAddress_ward())
//                    .Store_id(store.getStore_id())
//                    .Admin_id(store.getAdmin_id())
//                    .Created_date(store.getCreated_date())
//                    .End_date(store.getEnd_date())
//                    .Joining_date(store.getJoining_date())
//                    .Status(store.getStatus())
//                    .build();
//            ;
//        }

        return storeRepository.save(store);
    }
    @Override
    public void updateStore(Store store) {
        Store existingStore = getStoreById(store.getStore_id());
//        if (existingStore!=null) {
//            Store newStore = Store.builder()
//                    .Store_name(store.getStore_name())
//                    .Address(store.getAddress())
//                    .Address_city(store.getAddress_city())
//                    .Address_district(store.getAddress_district())
//                    .Address_ward(store.getAddress_ward())
//                    .Store_id(store.getStore_id())
//                    .Admin_id(store.getAdmin_id())
//                    .Created_date(store.getCreated_date())
//                    .End_date(store.getEnd_date())
//                    .Joining_date(store.getJoining_date())
//                    .Status(store.getStatus())
//                    .build();
//            ;
//        }
        if (existingStore!=null)
        storeRepository.save(store);
    }

    @Override
    public void deleteStore(Long id) {
        storeRepository.deleteById(id);
    }
}
