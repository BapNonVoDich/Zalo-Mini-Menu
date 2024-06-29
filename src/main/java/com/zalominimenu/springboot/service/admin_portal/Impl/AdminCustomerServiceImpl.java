package com.zalominimenu.springboot.service.admin_portal.Impl;

import com.zalominimenu.springboot.dto.admin_portal.auth.RegisterCustomerDTO;
import com.zalominimenu.springboot.model.Customer;
import com.zalominimenu.springboot.repository.admin_portal.AdminCustomerRepository;
import com.zalominimenu.springboot.service.admin_portal.AdminCustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AdminCustomerServiceImpl implements AdminCustomerService {
	private final AdminCustomerRepository adminCustomerRepository;

	@Override
	public Customer registerCustomer(RegisterCustomerDTO request) {
		return adminCustomerRepository.save(Customer.builder()
				.username(request.getUsername())
				.email(request.getEmail())
				.phoneNumber(request.getPhoneNumber())
				.role(request.getRole())
				.status(request.isStatus())
				.name(request.getName())
				.build());
	}
}
