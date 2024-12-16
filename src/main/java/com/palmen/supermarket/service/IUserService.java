package com.palmen.supermarket.service;

import com.palmen.supermarket.dto.RegisterDto;

public interface IUserService {

	Boolean registerUser(RegisterDto request);
}
