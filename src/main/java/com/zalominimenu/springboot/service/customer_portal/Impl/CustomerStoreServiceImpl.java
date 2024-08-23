package com.zalominimenu.springboot.service.customer_portal.Impl;

import com.zalominimenu.springboot.dto.customer_portal.requestDTO.CreateStoreRequest;
import com.zalominimenu.springboot.dto.customer_portal.requestDTO.UpdateStoreRequest;
import com.zalominimenu.springboot.model.Customer;
import com.zalominimenu.springboot.model.Store;
import com.zalominimenu.springboot.repository.customer_portal.CustomerStoreRepository;
import com.zalominimenu.springboot.service.customer_portal.CustomerStoreService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerStoreServiceImpl implements CustomerStoreService {
    private final CustomerStoreRepository storeRepository;

    @Override
    public Store createStore(CreateStoreRequest request) {

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
                .imageURL(request.getImageURL())
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
        Store store = storeRepository.findById(id).orElse(null);
        if (store != null) {
            return store;
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Không tìm thấy cửa hàng");
    }


    @Override
    public Store updateStore(UpdateStoreRequest updateStoreRequest) {
        Customer currentCustomer = (Customer) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Store existingStore = getStoreById(updateStoreRequest.getId());
        if (existingStore == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Không tìm thấy cửa hàng");
        }
        existingStore.setUpdatedAt(new Date());
        existingStore.setUpdatedBy(currentCustomer.getId());
        existingStore.setAddress(updateStoreRequest.getAddress());
        existingStore.setCity(updateStoreRequest.getCity());
        existingStore.setDistrict(updateStoreRequest.getDistrict());
        existingStore.setWard(updateStoreRequest.getWard());
        existingStore.setImageURL(updateStoreRequest.getImageURL());
        return storeRepository.save(existingStore);
    }

    @Override
    public Long deleteStore(Long id) {
        Long eff = storeRepository.deleteStoreById(id);
        if (eff == 0) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Không tìm thấy cửa hàng");
        }
        return eff;
    }
}
