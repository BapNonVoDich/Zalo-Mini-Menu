package com.zalominimenu.springboot.dto.customer_portal.requestDTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import java.util.Set;

@Data
public class UpdateProductRequest {
    @NotNull(message = "Tên không được để trống")
    @NotBlank(message = "Tên không được để trống")
    @Length(max = 50, message = "Tên không được quá 50 ký tự")
    @Length(min = 2, message = "Tên không được ít hơn 2 ký tự")
    private String productName;

    @NotNull(message = "Mô tả không được để trống")
    @NotBlank(message = "Mô tả không được để trống")
    @Length(max = 50, message = "Mô tả không được quá 50 ký tự")
    @Length(min = 2, message = "Mô tả không được ít hơn 2 ký tự")
    private String description;

    @NotNull(message = "Giá sản phẩm không được để trống")
    @Min(value = 0, message = "Giá sản phẩm không được nhỏ hơn 0")
    private Long productPrice;

    @NotNull(message = "Số lượng không được để trống")
    @Min(value = 0, message = "Số lượng không được nhỏ hơn 0")
    private Long stockQuantity;

    @NotNull(message = "ID danh mục không được để trống")
    private Set<Long> categoryIds;

    @NotNull(message = "ID cửa hàng không được để trống")
    private Long storeId;

    @NotNull(message = "URL ảnh không được để trống")
    @NotBlank(message = "URL ảnh không được để trống")
    @URL(message = "URL ảnh không hợp lệ")
    private String imageURL;

    @NotNull(message = "ID không được để trống")
    @Min(value = 1, message = "ID không được nhỏ hơn 1")
    private Long id;
}
