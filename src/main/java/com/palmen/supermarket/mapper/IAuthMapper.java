package com.palmen.supermarket.mapper;

import org.mapstruct.Mapper;
import com.palmen.supermarket.dto.LoginDTO;
import com.palmen.supermarket.dto.RegisterDTO;
import com.palmen.supermarket.input.LoginInput;
import com.palmen.supermarket.input.RegisterInput;

@Mapper(componentModel = "spring")
public interface IAuthMapper {

	RegisterDTO registerInputToRegisterDto(RegisterInput input);

	LoginDTO loginInputToLoginDto(LoginInput input);
}
