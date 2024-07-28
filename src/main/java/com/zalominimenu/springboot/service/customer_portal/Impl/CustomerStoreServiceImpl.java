package com.zalominimenu.springboot.service.customer_portal.Impl;

import com.zalominimenu.springboot.dto.customer_portal.requestDTO.CreateStoreDTO;
import com.zalominimenu.springboot.dto.customer_portal.requestDTO.UpdateStoreDTO;
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
    public Store createStore(CreateStoreDTO request) {

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
        List<Store> storeList = storeRepository.findAll();
        if (storeList!=null){
            return storeList;
        }
        throw new IllegalStateException("Danh sách cửa hàng trống");
    }

    @Override
    public Store getStoreById(Long id) {
        Store store = storeRepository.findById(id).get();
        if (store!=null){
            return store;
        }
        throw new IllegalStateException("Cửa hàng không tồn tại!");
    }



    @Override
    public Store updateStore(UpdateStoreDTO store) {

        Customer currentCustomer = (Customer) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Store existingStore = getStoreById(store.getId());
        if (existingStore!=null) {
            existingStore.setUpdatedAt(new Date());
            existingStore.setUpdatedBy(currentCustomer.getId());
            existingStore.setAddress(store.getAddress());
            existingStore.setCity(store.getCity());
            existingStore.setDistrict(store.getDistrict());
            existingStore.setWard(store.getWard());

            return storeRepository.save(existingStore);
        }
        throw new IllegalStateException("Cửa hàng không tồn tại!");
    }

    @Override
    public Long deleteStore(Long id) {
            return storeRepository.deleteStoreById(id);
    }
}
