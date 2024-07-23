package com.zalominimenu.springboot.dto.customer_portal.requestDTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.Length;


@Data
public class StoreDTO {
    @NotBlank(message = "Tên cửa hàng không được để trống")
    @Length(max = 50, message = "Tên cửa hàng không được quá 50 ký tự")
    private String name;

    @NotBlank(message = "Địa chỉ không được để trống")
    @Length(max = 100, message = "Địa chỉ không được quá 100 ký tự")
    @Length(min = 2, message = "Địa chỉ không được ít hơn 2 ký tự")
    private String address;

    @NotBlank(message = "Quận không được để trống")
    @Length(max = 100, message = "Quận không được quá 100 ký tự")
    @Length(min = 2, message = "Quận không được ít hơn 2 ký tự")
    private String ward;

    @NotBlank(message = "Huyện không được để trống")
    @Length(max = 50, message = "Huyện không được quá 50 ký tự")
    @Length(min = 2, message = "Huyện không được ít hơn 2 ký tự")
    private String district;

    @NotBlank(message = "Thành phố không được để trống")
    @Length(max = 50, message = "Thành phố không được quá 50 ký tự")
    @Length(min = 2, message = "Thành phố không được ít hơn 2 ký tự")
    private String city;
}
