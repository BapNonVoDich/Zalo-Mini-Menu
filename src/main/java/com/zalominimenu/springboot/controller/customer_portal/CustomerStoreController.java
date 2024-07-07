package com.zalominimenu.springboot.controller.customer_portal;

import com.zalominimenu.springboot.constant.SecurityConstants;
import com.zalominimenu.springboot.dto.BaseResponse;
import com.zalominimenu.springboot.dto.customer_portal.CreateStoreDTO;
import com.zalominimenu.springboot.model.Store;
import com.zalominimenu.springboot.service.customer_portal.CustomerStoreService;
import com.zalominimenu.springboot.utils.CustomResponseEntity;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/customer-portal/store")
@Slf4j
public class CustomerStoreController {
    private final CustomerStoreService storeService;
    @PostMapping("/")
    public ResponseEntity<BaseResponse<Long>> createStore(
            @Valid @RequestBody CreateStoreDTO request) {
        final Store store = storeService.createStore(request);
        return CustomResponseEntity.ok(store.getId(), "Tạo cửa hàng thành công");
    }
}