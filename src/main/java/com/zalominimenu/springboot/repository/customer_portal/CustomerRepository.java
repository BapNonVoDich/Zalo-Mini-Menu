package com.zalominimenu.springboot.repository.customer_portal;

import com.zalominimenu.springboot.model.Customer;
import com.zalominimenu.springboot.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    boolean existsCustomerById(Long id);
    Customer findCustomerByPhoneNumber(String phoneNumber);
    Customer findCustomerById(Long id);
}
