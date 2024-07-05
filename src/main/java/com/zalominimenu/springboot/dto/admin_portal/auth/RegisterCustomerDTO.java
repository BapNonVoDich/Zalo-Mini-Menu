package com.zalominimenu.springboot.dto.admin_portal.auth;

import com.zalominimenu.springboot.annotation.EnumValidatorCustomerRole;
import com.zalominimenu.springboot.enums.CustomerRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.Length;


@Data
public class RegisterCustomerDTO {
    @NotBlank(message = "Tên không được để trống")
    @Length(min = 3, message = "Tên phải có ít nhất 3 ký tự")
    private String name;

    @NotBlank(message = "Email không được để trống")
    @Email(message = "Email không hợp lệ")
    private String email;

    @NotBlank(message = "Mật khẩu không được để trống")
    @Length(min = 6, message = "Mật khẩu phải có ít nhất 6 ký")
    @Length(max = 50, message = "Mật khẩu không được quá 50 ký tự")
    private String username;

    @NotBlank(message = "Số điện thoại không được để trống")
    @Length(min = 10, message = "Số điện thoại phải có ít nhất 10 ký tự")
    @Length(max = 15, message = "Số điện thoại không được quá 15 ký tự")
    private String phoneNumber;

    @EnumValidatorCustomerRole(anyOf = {CustomerRole.ADMIN, CustomerRole.STAFF})
    private CustomerRole role;

    private boolean status;
}
