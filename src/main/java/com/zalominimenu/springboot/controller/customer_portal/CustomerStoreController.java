package com.zalominimenu.springboot.controller.customer_portal;

import com.zalominimenu.springboot.dto.BaseResponse;
import com.zalominimenu.springboot.dto.customer_portal.requestDTO.CreateStoreRequest;
import com.zalominimenu.springboot.dto.customer_portal.requestDTO.UpdateStoreRequest;
import com.zalominimenu.springboot.dto.customer_portal.responseDTO.StoreResponse;
import com.zalominimenu.springboot.mapper.StoreMapper;
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
@RequestMapping("/v1/customer-portal/store/")
@Slf4j
public class CustomerStoreController {
    private final CustomerStoreService storeService;

    @PostMapping
    public ResponseEntity<BaseResponse<StoreResponse>> createStore(
            @Valid @RequestBody CreateStoreRequest request) {
        final StoreResponse store = StoreMapper.INSTANCE.StoreToStoreResponse(storeService.createStore(request));

        log.info("Tạo cửa hàng thành công {}", store);
        return CustomResponseEntity.ok(store, "Tạo cửa hàng thành công");
    }

    @GetMapping("{id}")
    public ResponseEntity<BaseResponse<StoreResponse>> getStore(@PathVariable Long id) {
        final StoreResponse store = StoreMapper.INSTANCE.StoreToStoreResponse(storeService.getStoreById(id));
        return CustomResponseEntity.ok(store, "Lấy cửa hàng thành công");
    }

    @PutMapping()
    public ResponseEntity<BaseResponse<StoreResponse>> updateStore(@Valid @RequestBody UpdateStoreRequest store) {
        final StoreResponse updatedStore = StoreMapper.INSTANCE.StoreToStoreResponse(storeService.updateStore(store));
        return CustomResponseEntity.ok(updatedStore, "Cập nhật cửa hàng thành công");
    }

    @DeleteMapping("{id}")
    public ResponseEntity<BaseResponse<Long>> deleteStore(@PathVariable Long id) {
        final Long store = storeService.deleteStore(id);
        return CustomResponseEntity.ok(store, "Xoá cửa hàng thành công");
    }
}