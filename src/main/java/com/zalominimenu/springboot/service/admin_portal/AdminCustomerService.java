package com.zalominimenu.springboot.service.admin_portal;

import com.zalominimenu.springboot.dto.admin_portal.auth.RegisterCustomerDTO;
import com.zalominimenu.springboot.model.Customer;

public interface AdminCustomerService {
    Customer registerCustomer(RegisterCustomerDTO request);
}
