package com.zalominimenu.springboot.service;

import com.zalominimenu.springboot.model.User;
import com.zalominimenu.springboot.dto.auth.AuthenticatedUserDto;

public interface UserService {

	User findByUsername(String username);

	AuthenticatedUserDto findAuthenticatedUserByUsername(String username);

}
