package com.palmen.supermarket.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.palmen.supermarket.dto.LoginDto;
import com.palmen.supermarket.security.jwt.JwtTokenProvider;
import com.palmen.supermarket.service.IAuthService;

@Service
public class AuthServiceImpl implements IAuthService {

	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtTokenProvider jwtTokenProvider;

	@Override
	public String login(LoginDto loginDto) {

		// 01 - AuthenticationManager is used to authenticate the user
		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		String token = jwtTokenProvider.generateToken(authentication);

		return token;
	}

}
