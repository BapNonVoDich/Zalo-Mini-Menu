package com.zalominimenu.springboot.mapper;

import com.zalominimenu.springboot.dto.admin_portal.auth.AuthenticatedUserAdminDto;
import com.zalominimenu.springboot.dto.admin_portal.auth.UserInfo;
import com.zalominimenu.springboot.model.AdminUser;
import com.zalominimenu.springboot.security.jwt.CustomUserDetails;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AdminUserMapper {
	AdminUserMapper INSTANCE = Mappers.getMapper(AdminUserMapper.class);
	UserInfo convertToUserInfo(AdminUser user);
	CustomUserDetails convertToCustomUserDetails(AdminUser user);
}
