package com.zalominimenu.springboot.dto.customer_portal;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;

@Data
@Getter
public class CreateCategoryDTO {

    @NotBlank(message = "Tên không được để trống")
    @Length(max = 50, message = "Tên không được quá 50 ký tự")
    @Length(min = 2, message = "Tên không được ít hơn 2 ký tự")
    private String categoryName;

    @NotBlank(message = "Mo ta không được để trống")
    @Length(max = 50, message = "mo ta không được quá 50 ký tự")
    @Length(min = 2, message = "mo ta không được ít hơn 2 ký tự")
    private String description;

    @NotBlank(message = "Cua hang không được để trống")
    @Length(max = 50, message = "cua hang không được quá 50 ký tự")
    @Length(min = 2, message = "cua hang không được ít hơn 2 ký tự")
    private Long storeId;
}
