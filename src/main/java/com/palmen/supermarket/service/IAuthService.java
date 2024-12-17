package com.palmen.supermarket.service;

import com.palmen.supermarket.dto.LoginDTO;

public interface IAuthService {
	String login(LoginDTO loginDto);
}
