package com.palmen.supermarket.service;

import com.palmen.supermarket.dto.LoginDto;

public interface IAuthService {
	String login(LoginDto loginDto);
}
