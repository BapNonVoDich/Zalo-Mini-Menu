package com.zalominimenu.springboot.mapper;

import com.zalominimenu.springboot.dto.admin_portal.auth.UserInfo;
import com.zalominimenu.springboot.model.AdminUser;
import com.zalominimenu.springboot.security.jwt.CustomUserDetails;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AdminUserMapper {
    AdminUserMapper INSTANCE = Mappers.getMapper(AdminUserMapper.class);

    UserInfo convertToUserInfo(AdminUser user);

    CustomUserDetails convertToCustomUserDetails(AdminUser user);
}
