package com.palmen.supermarket.dto;

import java.time.LocalDate;

import com.palmen.supermarket.persistence.entity.ProductType;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

	private Long id;
	private String name;
	private String description;
	private Double weight;
	private Double basePrice;
	private String imageUrl;
	private String brandName;
	private String categoryName;
	private LocalDate expirationDate;
	@Enumerated(EnumType.STRING)
	private ProductType productType;

}
