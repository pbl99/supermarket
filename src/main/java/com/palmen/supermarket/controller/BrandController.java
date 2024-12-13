package com.palmen.supermarket.controller;

import java.util.List;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import com.palmen.supermarket.dto.BrandDTO;
import com.palmen.supermarket.input.BrandInput;
import com.palmen.supermarket.mapper.IBrandMapper;
import com.palmen.supermarket.service.IBrandService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BrandController {

	private final IBrandService brandService;
	private final IBrandMapper brandMapper;

	@MutationMapping
	public Boolean createBrand(@Argument("brandInput") BrandInput brandInput) {
		return brandService.createBrand(brandMapper.brandInputToBrandDTO(brandInput));
	}

	@MutationMapping
	public Boolean deleteBrand(@Argument("id") Long id) {
		return brandService.deleteBrand(id);
	}

	@QueryMapping
	public BrandDTO findBrand(@Argument("id") Long id) {
		return brandService.findBrand(id);
	}

	@QueryMapping
	public List<BrandDTO> findAllBrands() {
		return brandService.findAllBrands();
	}
}
