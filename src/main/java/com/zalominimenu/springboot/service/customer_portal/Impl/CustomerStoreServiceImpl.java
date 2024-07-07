package com.zalominimenu.springboot.service.customer_portal.Impl;

import com.zalominimenu.springboot.dto.customer_portal.CreateStoreDTO;
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
                .managers(managers)
                .build();

        return storeRepository.save(store);
    }
}
