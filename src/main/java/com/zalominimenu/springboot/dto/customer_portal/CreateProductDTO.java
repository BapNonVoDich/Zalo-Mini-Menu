package com.zalominimenu.springboot.dto.customer_portal;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;

@Data
@Getter
public class CreateProductDTO {
    @NotBlank(message = "Tên không được để trống")
    @Length(max = 50, message = "Tên không được quá 50 ký tự")
    @Length(min = 2, message = "Tên không được ít hơn 2 ký tự")
    private String productName;
    @NotBlank(message = "Mô tả không được để trống")
    @Length(max = 50, message = "Mô tả không được quá 50 ký tự")
    @Length(min = 2, message = "Mô tả không được ít hơn 2 ký tự")
    private String description;
    @NotBlank(message = "Giá không được để trống")
    @Length(max = 50, message = "Giá không được quá 50 ký tự")
    @Length(min = 2, message = "Giá không được ít hơn 2 ký tự")
    private Long productPrice;

    @Length(max = 50, message = "Số lượng không được quá 50 ký tự")
    private Long stockQuantity;
    @NotBlank(message = "Cửa hàng không được để trống")
    @Length(max = 50, message = "Cửa hàng không được quá 50 ký tự")
    @Length(min = 2, message = "Cửa hàng không được ít hơn 2 ký tự")
    private Long storeId;

}
