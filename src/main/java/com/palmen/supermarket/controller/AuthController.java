package com.palmen.supermarket.controller;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

import com.palmen.supermarket.dto.AuthResponseDto;
import com.palmen.supermarket.dto.LoginDto;
import com.palmen.supermarket.dto.RegisterDto;
import com.palmen.supermarket.input.LoginInput;
import com.palmen.supermarket.input.RegisterInput;
import com.palmen.supermarket.mapper.IAuthMapper;
import com.palmen.supermarket.service.IAuthService;
import com.palmen.supermarket.service.IUserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class AuthController {

	private final IUserService customUserService;
	private final IAuthService authService;
	private final IAuthMapper authMapper; 

	@MutationMapping
	public Boolean registerUser(@Argument("registerInput") RegisterInput registerInput) {
		RegisterDto registerDto = authMapper.registerInputToRegisterDto(registerInput);
		customUserService.registerUser(registerDto);
		return true;
	}

	@MutationMapping
	public AuthResponseDto loginUser(@Argument("loginInput") LoginInput loginInput) {
		LoginDto loginDto = authMapper.loginInputToLoginDto(loginInput);
		String token = authService.login(loginDto);
		return AuthResponseDto.builder().accessToken(token).build();
	}
}
