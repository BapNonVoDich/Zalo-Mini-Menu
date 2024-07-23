package com.zalominimenu.springboot.dto.customer_portal.requestDTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;

import java.util.Set;

@Data
@Getter
public class ProductDTO {
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

    @NotBlank(message = "Giá không được để trống")
    private Set<Long> categoryIds;
}
