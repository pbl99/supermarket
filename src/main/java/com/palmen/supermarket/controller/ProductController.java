package com.palmen.supermarket.controller;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.palmen.supermarket.dto.ProductDTO;
import com.palmen.supermarket.input.ProductInput;
import com.palmen.supermarket.mapper.IProductMapper;
import com.palmen.supermarket.service.IProductService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ProductController {

	private final IProductService productService;
	private final IProductMapper productMapper;

	@MutationMapping
	public Boolean createProduct(@Argument("productInput") ProductInput productInput) {
		return productService.createProduct(productMapper.productInputToProductDTO(productInput));
	}

	@MutationMapping
	public Boolean deleteProduct(@Argument("id") Long id) {
		return productService.deleteProduct(id);
	}

	@QueryMapping
	public ProductDTO findProduct(@Argument("id") Long id) {
		return productService.findProduct(id);
	}

	@QueryMapping
	public List<ProductDTO> findAllProducts() {
		return productService.findAllProducts();
	}
}
