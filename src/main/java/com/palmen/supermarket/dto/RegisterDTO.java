package com.palmen.supermarket.dto;

import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterDTO {

	private String username;
	private String email;
	private String password;
}
