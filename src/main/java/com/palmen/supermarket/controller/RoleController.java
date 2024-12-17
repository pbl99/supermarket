package com.palmen.supermarket.controller;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.palmen.supermarket.dto.RoleDTO;
import com.palmen.supermarket.input.RoleInput;
import com.palmen.supermarket.mapper.IRoleMapper;
import com.palmen.supermarket.service.IRoleService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class RoleController {

	private final IRoleService roleService;
	private final IRoleMapper roleMapper;

	@MutationMapping
	public Boolean createRole(@Argument("roleInput") RoleInput roleInput) {
		return roleService.createRole(roleMapper.roleInputToRoleDTO(roleInput));
	}

	@MutationMapping
	public RoleDTO updateRole(@Argument("roleInput") RoleInput roleInput) {
		return roleService.updateRole(roleMapper.roleInputToRoleDTO(roleInput));
	}

	@MutationMapping
	public Boolean deleteRole(@Argument("id") Long id) {
		return roleService.deleteRole(id);
	}

	@QueryMapping
	public List<RoleDTO> findAllRoles() {
		return roleService.findAllRoles();
	}
}
