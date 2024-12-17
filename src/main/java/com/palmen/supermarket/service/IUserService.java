package com.palmen.supermarket.service;

import com.palmen.supermarket.dto.RegisterDTO;

public interface IUserService {

	Boolean registerUser(RegisterDTO request);
}
