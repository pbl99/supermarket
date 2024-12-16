package com.palmen.supermarket.dto;

import lombok.Data;
import lombok.Builder;

@Data
@Builder
public class AuthResponseDto {

	private String accessToken;
}
