package com.palmen.supermarket.controller;

import java.util.List;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import com.palmen.supermarket.dto.CategoryDTO;
import com.palmen.supermarket.input.CategoryInput;
import com.palmen.supermarket.mapper.ICategoryMapper;
import com.palmen.supermarket.service.ICategoryService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class CategoryController {

	private final ICategoryService categoryService;
	private final ICategoryMapper categoryMapper;

	@MutationMapping
	public Boolean createCategory(@Argument("categoryInput") CategoryInput categoryInput) {
		System.out.println(">>> createCategory invoked. Input name: " + categoryInput.getName());
		if (categoryInput == null || categoryInput.getName() == null) {
			System.out.println(">>> categoryInput is null or has no name!");
			return false;
		}
		CategoryDTO categoryDTO = categoryMapper.categoryInputToCategoryDTO(categoryInput);
		System.out.println(">>> Mapped CategoryDTO: " + categoryDTO);
		return categoryService.createCategory(categoryDTO);
	}

	@MutationMapping
	public Boolean deleteCategory(@Argument("id") Long id) {
		return categoryService.deleteCategory(id);
	}

	@QueryMapping
	public CategoryDTO findCategory(@Argument("id") Long id) {
		return categoryService.findCategory(id);
	}

	@QueryMapping
	public List<CategoryDTO> findAllCategories() {
		return categoryService.findAllCategories();
	}
}
