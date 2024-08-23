package com.zalominimenu.springboot.controller.customer_portal;

import com.zalominimenu.springboot.dto.BaseListResponse;
import com.zalominimenu.springboot.dto.BaseResponse;
import com.zalominimenu.springboot.dto.customer_portal.requestDTO.CreateProductRequest;
import com.zalominimenu.springboot.dto.customer_portal.requestDTO.ListProductRequest;
import com.zalominimenu.springboot.dto.customer_portal.requestDTO.UpdateProductRequest;
import com.zalominimenu.springboot.dto.customer_portal.responseDTO.ProductResponse;
import com.zalominimenu.springboot.mapper.ProductMapper;
import com.zalominimenu.springboot.service.customer_portal.CustomerProductService;
import com.zalominimenu.springboot.utils.CustomResponseEntity;
import com.zalominimenu.springboot.utils.CustomResponseListEntity;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@Slf4j
@RequestMapping("/v1/customer-portal/product/")

public class CustomerProductController {


    private final CustomerProductService productService;

    @GetMapping
    @ResponseBody
    public ResponseEntity<BaseListResponse<ProductResponse>> listProducts(ListProductRequest request) {
        final Page<ProductResponse> products = ProductMapper.INSTANCE.ProductsToProductResponses(productService.getListProducts(request));
        return CustomResponseListEntity.ok(products, "Lấy danh sách sản phẩm thành công");
    }

    @GetMapping("{id}")
    public ResponseEntity<BaseResponse<ProductResponse>> getProductById(@PathVariable Long id) {
        final ProductResponse product = ProductMapper.INSTANCE.ProductToProductResponse(productService.getProductById(id));
        return CustomResponseEntity.ok(product, "Lấy sản phẩm thành công");
    }


    @PostMapping()
    public ResponseEntity<BaseResponse<ProductResponse>> createProduct(@Valid @RequestBody CreateProductRequest productDTO) {
        productService.createProduct(productDTO);
        return CustomResponseEntity.ok(null, "Thêm sản phẩm vào cửa hàng thành công");
    }

    @PutMapping()
    public ResponseEntity<BaseResponse<ProductResponse>> updateProduct(@Valid @RequestBody UpdateProductRequest productDTO) {
        productService.updateProduct(productDTO);
        return CustomResponseEntity.ok(null, "Cập nhật sản phẩm thành công");
    }

    @DeleteMapping("{id}")
    public ResponseEntity<BaseResponse<Long>> deleteProduct(@PathVariable Long id) {
        final Long deletedProduct = productService.deleteProduct(id);
        return CustomResponseEntity.ok(deletedProduct, "Xoá sản phẩm thành công");
    }


}
