package com.palmen.supermarket.mapper;

import org.mapstruct.Mapper;
import com.palmen.supermarket.dto.LoginDto;
import com.palmen.supermarket.dto.RegisterDto;
import com.palmen.supermarket.input.LoginInput;
import com.palmen.supermarket.input.RegisterInput;

@Mapper(componentModel = "spring")
public interface IAuthMapper {

	RegisterDto registerInputToRegisterDto(RegisterInput input);

	LoginDto loginInputToLoginDto(LoginInput input);
}
