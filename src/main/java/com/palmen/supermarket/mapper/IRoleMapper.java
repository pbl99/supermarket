package com.palmen.supermarket.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.palmen.supermarket.dto.RoleDTO;
import com.palmen.supermarket.input.RoleInput;
import com.palmen.supermarket.persistence.entity.Role;

@Mapper(componentModel = "spring")
public interface IRoleMapper {

	Role roleDTOToRole(RoleDTO roleDTO);

	RoleDTO roleToRoleDTO(Role role);

	@Mapping(target = "id", ignore = true)
	RoleDTO roleInputToRoleDTO(RoleInput roleInput);
}
