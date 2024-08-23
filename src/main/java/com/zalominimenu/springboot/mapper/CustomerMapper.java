package com.zalominimenu.springboot.mapper;

import com.zalominimenu.springboot.model.Customer;
import com.zalominimenu.springboot.security.jwt.CustomUserDetails;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    CustomUserDetails convertToCustomUserDetails(Customer customer);
}
