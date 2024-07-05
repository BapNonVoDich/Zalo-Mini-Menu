package com.zalominimenu.springboot.controller.admin_portal;

import com.zalominimenu.springboot.dto.BaseResponse;
import com.zalominimenu.springboot.dto.admin_portal.auth.RegisterCustomerDTO;
import com.zalominimenu.springboot.model.Customer;
import com.zalominimenu.springboot.service.admin_portal.AdminCustomerService;
import com.zalominimenu.springboot.utils.CustomResponseEntity;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/admin-portal/customer")
@Slf4j
public class AdminCustomerController {
	private final AdminCustomerService adminCustomerService;

	@PostMapping("/register")
	public ResponseEntity<BaseResponse<Long>> registerCustomer(@Valid @RequestBody RegisterCustomerDTO request) {
		final Customer customer = adminCustomerService.registerCustomer(request);

		return CustomResponseEntity.ok(customer.getId(), "Đăng ký khách hàng thành công");
	}
}
