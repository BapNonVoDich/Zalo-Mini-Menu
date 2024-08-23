package com.zalominimenu.springboot.dto.customer_portal.requestDTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class UpdateCategoryRequest {
    @NotBlank(message = "ID không được để trống")
    private Long id;
    @NotBlank(message = "Tên không được để trống")
    @Length(max = 50, message = "Tên không được quá 50 ký tự")
    @Length(min = 2, message = "Tên không được ít hơn 2 ký tự")
    private String categoryName;

    @NotBlank(message = "Mô tả không được để trống")
    @Length(max = 50, message = "Mô tả không được quá 50 ký tự")
    @Length(min = 2, message = "Mô tả không được ít hơn 2 ký tự")
    private String description;

}
