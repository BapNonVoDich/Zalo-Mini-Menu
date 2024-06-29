package com.zalominimenu.springboot.mapper;

import com.zalominimenu.springboot.dto.admin_portal.auth.UserInfo;
import com.zalominimenu.springboot.model.AdminUser;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AdminCustomerMapper {
	AdminCustomerMapper INSTANCE = Mappers.getMapper(AdminCustomerMapper.class);
}
