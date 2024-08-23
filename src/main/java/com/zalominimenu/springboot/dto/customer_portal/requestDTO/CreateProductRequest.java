package com.zalominimenu.springboot.dto.customer_portal.requestDTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import java.util.Set;

@Data
@Getter
public class CreateProductRequest {
    @NotBlank(message = "Tên không được để trống")
    @Length(max = 50, message = "Tên không được quá 50 ký tự")
    @Length(min = 2, message = "Tên không được ít hơn 2 ký tự")
    @NotNull(message = "Tên không được để trống")
    private String productName;

    @NotBlank(message = "Mô tả không được để trống")
    @Length(max = 50, message = "Mô tả không được quá 50 ký tự")
    @Length(min = 2, message = "Mô tả không được ít hơn 2 ký tự")
    @NotNull(message = "Tên không được để trống")
    private String description;

    @NotNull(message = "Giá không được để trống")
    @Min(value = 0, message = "Giá không được nhỏ hơn 0")
    private Long productPrice;

    @NotNull(message = "Số lượng không được để trống")
    @Min(value = 0, message = "Số lượng không được nhỏ hơn 0")
    private Long stockQuantity;

    @NotNull(message = "Id danh mục không được để trống")
    @NotEmpty(message = "Id danh mục không được để trống")
    private Set<Long> categoryIds;

    @NotNull(message = "Id cửa hàng không được để trống")
    private Long storeId;

    @NotNull(message = "Hình ảnh không được để trống")
    @NotEmpty(message = "Hình ảnh không được để trống")
    @URL(message = "Hình ảnh không đúng định dạng")
    private String imageURL;
}
