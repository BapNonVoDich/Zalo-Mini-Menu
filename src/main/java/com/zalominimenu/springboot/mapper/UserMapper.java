package com.zalominimenu.springboot.mapper;

import com.zalominimenu.springboot.dto.auth.UserInfo;
import com.zalominimenu.springboot.model.User;
import com.zalominimenu.springboot.dto.auth.AuthenticatedUserDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

	AuthenticatedUserDto convertToAuthenticatedUserDto(User user);

	User convertToUser(AuthenticatedUserDto authenticatedUserDto);
	UserInfo convertToUserInfo(User user);

}
