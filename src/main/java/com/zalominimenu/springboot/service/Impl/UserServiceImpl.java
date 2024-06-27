package com.zalominimenu.springboot.service.Impl;

import com.zalominimenu.springboot.service.UserService;
import com.zalominimenu.springboot.service.UserValidationService;
import com.zalominimenu.springboot.model.User;
import com.zalominimenu.springboot.dto.auth.AuthenticatedUserDto;
import com.zalominimenu.springboot.mapper.UserMapper;
import com.zalominimenu.springboot.utils.GeneralMessageAccessor;
import com.zalominimenu.springboot.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private static final String REGISTRATION_SUCCESSFUL = "registration_successful";

	private final UserRepository userRepository;

	private final BCryptPasswordEncoder bCryptPasswordEncoder;

	private final UserValidationService userValidationService;

	private final GeneralMessageAccessor generalMessageAccessor;

	@Override
	public User findByUsername(String username) {

		return userRepository.findByUsername(username);
	}

	@Override
	public AuthenticatedUserDto findAuthenticatedUserByUsername(String username) {

		final User user = findByUsername(username);

		return UserMapper.INSTANCE.convertToAuthenticatedUserDto(user);
	}
}
