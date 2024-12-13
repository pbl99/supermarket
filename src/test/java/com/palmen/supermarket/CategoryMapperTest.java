package com.palmen.supermarket;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.palmen.supermarket.dto.CategoryDTO;
import com.palmen.supermarket.input.CategoryInput;
import com.palmen.supermarket.mapper.ICategoryMapper;

@SpringBootTest
public class CategoryMapperTest {

	@Autowired
	private ICategoryMapper categoryMapper;

	@Test
	public void testCategoryInputToCategoryDTO() {
		CategoryInput input = new CategoryInput();
		input.setName("Conservas");

		CategoryDTO dto = categoryMapper.categoryInputToCategoryDTO(input);

		assertNotNull(dto);
		assertEquals("Conservas", dto.getName());
	}
}