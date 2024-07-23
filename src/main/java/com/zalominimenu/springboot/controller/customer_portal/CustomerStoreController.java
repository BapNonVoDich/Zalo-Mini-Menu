package com.zalominimenu.springboot.controller.customer_portal;

import com.zalominimenu.springboot.dto.BaseResponse;
import com.zalominimenu.springboot.dto.customer_portal.requestDTO.StoreDTO;
import com.zalominimenu.springboot.dto.customer_portal.responseDTO.StoreResponse;
import com.zalominimenu.springboot.mapper.ResponseMapper;
import com.zalominimenu.springboot.model.Store;
import com.zalominimenu.springboot.service.customer_portal.CustomerStoreService;
import com.zalominimenu.springboot.utils.CustomResponseEntity;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/customer-portal/store/")
@Slf4j
public class CustomerStoreController {
    private final CustomerStoreService storeService;
    @Autowired
    private ResponseMapper responseMapper;
    @PostMapping
    public ResponseEntity<BaseResponse<StoreResponse>> createStore(
            @Valid @RequestBody StoreDTO request) {
        final StoreResponse store = responseMapper.StoreToStoreResponse(storeService.createStore(request));
        return CustomResponseEntity.ok(store, "Tạo cửa hàng thành công");
    }
    @GetMapping("{id}")
    public ResponseEntity<BaseResponse<StoreResponse>> getStore(@PathVariable Long id) {
        final StoreResponse store = responseMapper.StoreToStoreResponse(storeService.getStoreById(id));
        return CustomResponseEntity.ok(store, "Lấy cửa hàng thành công");
    }

    @GetMapping
    public ResponseEntity<BaseResponse<List<StoreResponse>>> getAllStore() {
        final List<StoreResponse> stores = responseMapper.StoresToStoreResponses(storeService.getAllStores());
        return CustomResponseEntity.ok(stores, "Trả về tất cả của hàng thành công");
    }

    @DeleteMapping("{id}")
    public ResponseEntity<BaseResponse<StoreResponse>> deleteStore(@PathVariable Long id){
        final StoreResponse store = responseMapper.StoreToStoreResponse(storeService.deleteStore(id));
        return CustomResponseEntity.ok(store,"Xoá cửa hàng thành công");
    }
}