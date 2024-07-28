package com.zalominimenu.springboot.controller.customer_portal;

import com.zalominimenu.springboot.dto.BaseResponse;
import com.zalominimenu.springboot.dto.customer_portal.requestDTO.CreateStoreDTO;
import com.zalominimenu.springboot.dto.customer_portal.requestDTO.UpdateStoreDTO;
import com.zalominimenu.springboot.dto.customer_portal.responseDTO.StoreResponse;
import com.zalominimenu.springboot.mapper.StoreMapper;
import com.zalominimenu.springboot.service.customer_portal.CustomerStoreService;
import com.zalominimenu.springboot.utils.CustomResponseEntity;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/customer-portal/store/")
@Slf4j
public class CustomerStoreController {
    private final CustomerStoreService storeService;
    @Autowired
    private StoreMapper responseMapper;
    @PostMapping
    public ResponseEntity<BaseResponse<StoreResponse>> createStore(
            @Valid @RequestBody CreateStoreDTO request) {
        final StoreResponse store = responseMapper.StoreToStoreResponse(storeService.createStore(request));
        return CustomResponseEntity.ok(store, "Tạo cửa hàng thành công");
    }
    @GetMapping("{id}")
    public ResponseEntity<BaseResponse<StoreResponse>> getStore(@PathVariable Long id) {
        final StoreResponse store = responseMapper.StoreToStoreResponse(storeService.getStoreById(id));
        return CustomResponseEntity.ok(store, "Lấy cửa hàng thành công");
    }

    @PutMapping()
    public ResponseEntity<BaseResponse<StoreResponse>> updateStore(@Valid @RequestBody UpdateStoreDTO store){
        final StoreResponse updatedStore = responseMapper.StoreToStoreResponse(storeService.updateStore(store));
        return CustomResponseEntity.ok(updatedStore, "Cập nhật cửa hàng thành công");
    }

    @DeleteMapping("{id}")
    public ResponseEntity<BaseResponse<Long>> deleteStore(@PathVariable Long id){
        final Long store = storeService.deleteStore(id);
        return CustomResponseEntity.ok(store,"Xoá cửa hàng thành công");
    }
}