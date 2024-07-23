package com.zalominimenu.springboot.service.customer_portal.Impl;

import com.zalominimenu.springboot.dto.customer_portal.requestDTO.StoreDTO;
import com.zalominimenu.springboot.model.Customer;
import com.zalominimenu.springboot.model.Store;
import com.zalominimenu.springboot.repository.customer_portal.CustomerStoreRepository;
import com.zalominimenu.springboot.service.customer_portal.CustomerStoreService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerStoreServiceImpl implements CustomerStoreService {
    private final CustomerStoreRepository storeRepository;
    @Override
    public Store createStore(StoreDTO request) {

        Customer currentCustomer = (Customer) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Set<Customer> managers = new HashSet<>(
                Collections.singletonList(currentCustomer)
        );
        final Store store = new Store().builder()
                .name(request.getName())
                .address(request.getAddress())
                .district(request.getDistrict())
                .city(request.getCity())
                .status(false)
                .updatedBy(currentCustomer.getId())
                .imageURL("src/main/resources/image/store")
                .managers(managers)
                .build();
        return storeRepository.save(store);
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
    public Store updateStore(Store store) {
        Store existingStore = getStoreById(store.getId());
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
            return storeRepository.save(store);
        return existingStore;
    }

    @Override
    public Store deleteStore(Long id) {
        Store existingStore = getStoreById(id);
        storeRepository.deleteById(id);
        return existingStore;
    }
}
