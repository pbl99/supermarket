package com.palmen.supermarket.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.palmen.supermarket.dto.ProductDTO;
import com.palmen.supermarket.mapper.IProductMapper;
import com.palmen.supermarket.persistence.entity.Brand;
import com.palmen.supermarket.persistence.entity.Category;
import com.palmen.supermarket.persistence.entity.Product;
import com.palmen.supermarket.persistence.repository.IBrandRepository;
import com.palmen.supermarket.persistence.repository.ICategoryRepository;
import com.palmen.supermarket.persistence.repository.IProductRepository;
import com.palmen.supermarket.service.IProductService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements IProductService {

	private final IProductRepository productRepository;
	private final IBrandRepository brandRepository;
	private final ICategoryRepository categoryRepository;
	private final IProductMapper productMapper;

	@Transactional
	@Override
	public Boolean createProduct(ProductDTO productDTO) {
		Brand brand = brandRepository.findByName(productDTO.getBrandName())
				.orElseThrow(() -> new RuntimeException("Brand not found: " + productDTO.getBrandName()));

		Category category = categoryRepository.findByName(productDTO.getCategoryName())
				.orElseThrow(() -> new RuntimeException("Category not found: " + productDTO.getCategoryName()));

		Product product = productMapper.productDTOToProduct(productDTO);

		product.setBrand(brand);
		product.setCategory(category);

		Product savedProduct = productRepository.save(product);

		return savedProduct.getId() != null;
	}

	@Transactional
	@Override
	public Boolean deleteProduct(Long id) {
		if (productRepository.existsById(id)) {
			productRepository.deleteById(id);
			return true;
		}
		return false;
	}

	@Transactional(readOnly = true)
	@Override
	public ProductDTO findProduct(Long id) {
		return productRepository.findById(id).map(productMapper::productToProductDTO)
				.orElseThrow(() -> new RuntimeException("Product not found"));
	}

	@Transactional(readOnly = true)
	@Override
	public List<ProductDTO> findAllProducts() {
		return productRepository.findAll().stream().map(productMapper::productToProductDTO)
				.collect(Collectors.toList());
	}
}
