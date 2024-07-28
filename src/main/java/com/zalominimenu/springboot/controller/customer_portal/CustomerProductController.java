package com.zalominimenu.springboot.controller.customer_portal;

import com.zalominimenu.springboot.dto.BaseResponse;
import com.zalominimenu.springboot.dto.customer_portal.requestDTO.CreateProductDTO;
import com.zalominimenu.springboot.dto.customer_portal.requestDTO.UpdateProductDTO;
import com.zalominimenu.springboot.dto.customer_portal.responseDTO.ProductResponse;
import com.zalominimenu.springboot.mapper.ProductMapper;
import com.zalominimenu.springboot.service.customer_portal.CustomerProductService;
import com.zalominimenu.springboot.utils.CustomResponseEntity;
import com.zalominimenu.springboot.utils.CustomResponseListEntity;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@Slf4j
@RequestMapping("/v1/customer-portal/product/")

public class CustomerProductController {


    private final CustomerProductService productService;
    @Autowired
    private ProductMapper responseMapper;

    @GetMapping
    public ResponseEntity<BaseResponse<List<ProductResponse>>> getAllProducts() {
        final List<ProductResponse> products = responseMapper.ProductsToProductResponses(productService.getAllProducts());
        return CustomResponseListEntity.ok(products,"Trả về tất cả sản phẩm thành công");
    }

    @GetMapping("{id}")
    public ResponseEntity<BaseResponse<ProductResponse>> getProductById(@PathVariable Long id) {
        final ProductResponse product = responseMapper.ProductToProductResponse(productService.getProductById(id));
        return CustomResponseEntity.ok(product,"Lấy sản phẩm thành công");
    }


    @PostMapping()
    public ResponseEntity<BaseResponse<ProductResponse>> createProduct(@Valid @RequestBody CreateProductDTO productDTO) {
        final ProductResponse addedProduct = responseMapper.ProductToProductResponse(productService.createProduct(productDTO));
        return CustomResponseEntity.ok(addedProduct,"Thêm sản phẩm vào cửa hàng thành công");
    }

    @PutMapping()
    public ResponseEntity<BaseResponse<ProductResponse>> updateProduct(@Valid @RequestBody UpdateProductDTO productDTO) {
        final ProductResponse updatedProduct =  responseMapper.ProductToProductResponse(productService.updateProduct(productDTO));
            return CustomResponseEntity.ok(updatedProduct,"Cập nhật sản phẩm thành công");
    }

    @DeleteMapping("{id}")
    public ResponseEntity<BaseResponse<Long>> deleteProduct(@PathVariable Long id) {
        final Long deletedProduct= productService.deleteProduct(id);
        return CustomResponseEntity.ok(deletedProduct,"Xoá sản phẩm thành công");
    }


}
