package com.zalominimenu.springboot.controller.customer_portal;

import com.zalominimenu.springboot.dto.BaseResponse;
import com.zalominimenu.springboot.dto.customer_portal.requestDTO.ProductDTO;
import com.zalominimenu.springboot.dto.customer_portal.responseDTO.ProductResponse;
import com.zalominimenu.springboot.mapper.ResponseMapper;
import com.zalominimenu.springboot.model.Product;
import com.zalominimenu.springboot.service.customer_portal.ProductService;
import com.zalominimenu.springboot.utils.CustomResponseEntity;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/v1/customer-portal/product/")
public class ProductController {

    private final ProductService productService;
    @Autowired
    private ResponseMapper responseMapper;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<BaseResponse<List<ProductResponse>>> getAllProducts() {
        final List<ProductResponse> products = responseMapper.ProductsToProductResponses(productService.getAllProducts());
        return CustomResponseEntity.ok(products,"Trả về tất cả sản phẩm thành công");
    }

    @GetMapping("/{id}")
    public ResponseEntity<BaseResponse<ProductResponse>> getProductById(@PathVariable Long id) {
        final ProductResponse product = responseMapper.ProductToProductResponse(productService.getProductById(id));
        return CustomResponseEntity.ok(product,"Lấy sản phẩm thành công");
    }

    @GetMapping("category/{id}")
    public ResponseEntity<BaseResponse<List<ProductResponse>>> getProductsByCategoryId(@PathVariable Long id) {
        final List<ProductResponse> products = responseMapper.ProductsToProductResponses(productService.getProductsByCategory(id));
        return CustomResponseEntity.ok(products,"Lấy sản phẩm theo danh mục thành công");

    }
    @GetMapping("category")
    public ResponseEntity<BaseResponse<List<ProductResponse>>> getProductsByCategoryIds(@RequestParam List<Long> ids) {
        final List<ProductResponse> products = responseMapper.ProductsToProductResponses(productService.getProductsByCategories(ids));
        return CustomResponseEntity.ok(products,"Lấy sản phẩm theo nhiều danh mục thành công");

    }

    @PostMapping("{storeId}")
    public ResponseEntity<BaseResponse<ProductResponse>> addProduct(@Valid @RequestBody ProductDTO productDTO,@PathVariable Long storeId) {
        final ProductResponse addedProduct = responseMapper.ProductToProductResponse(productService.createProduct(productDTO,storeId));
        return CustomResponseEntity.ok(addedProduct,"Thêm sản phẩm vào cửa hàng thành công");
    }

    @PutMapping("{productId}")
    public ResponseEntity<BaseResponse<ProductResponse>> updateProduct(@Valid @RequestBody ProductDTO productDTO, @PathVariable Long productId) {
        final ProductResponse updatedProduct =  responseMapper.ProductToProductResponse(productService.updateProduct(productDTO, productId));
            return CustomResponseEntity.ok(updatedProduct,"Cập nhật sản phẩm thành công");
    }

    @DeleteMapping("{id}")
    public ResponseEntity<BaseResponse<ProductResponse>> deleteProduct(@PathVariable Long id) {
        final ProductResponse deletedProduct= responseMapper.ProductToProductResponse(productService.deleteProduct(id));
        return CustomResponseEntity.ok(deletedProduct,"Xoá sản phẩm thành công");
    }


    @GetMapping("store/{id}")
    public ResponseEntity<BaseResponse<List<Product>>> getProductsByStore(@PathVariable Long id) {
        final List<Product> products = productService.getProductsByStore(id);
        return CustomResponseEntity.ok(products,"Lấy sản phẩm theo cửa hàng thành công");
    }

}
