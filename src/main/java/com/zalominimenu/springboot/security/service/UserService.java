package com.zalominimenu.springboot.security.service;

import com.zalominimenu.springboot.model.User;
import com.zalominimenu.springboot.security.dto.AuthenticatedUserDto;
import com.zalominimenu.springboot.security.dto.RegistrationRequest;
import com.zalominimenu.springboot.security.dto.RegistrationResponse;

// rimmel asghar
public interface UserService {

	User findByUsername(String username);

	RegistrationResponse registration(RegistrationRequest registrationRequest);

	AuthenticatedUserDto findAuthenticatedUserByUsername(String username);

}
