package com.palmen.supermarket.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.palmen.supermarket.dto.RegisterDto;
import com.palmen.supermarket.persistence.entity.User;
import com.palmen.supermarket.persistence.repository.IUserRepository;
import com.palmen.supermarket.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserRepository customUserRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public Boolean registerUser(RegisterDto request) {
		User user = new User();
		user.setUsername(request.getUsername());
		user.setEmail(request.getEmail());
		user.setPassword(passwordEncoder.encode(request.getPassword()));

		return customUserRepository.save(user) != null;
	}

}
