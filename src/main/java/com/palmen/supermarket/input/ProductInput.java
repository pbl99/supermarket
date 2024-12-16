package com.palmen.supermarket.input;

import java.time.LocalDate;

import com.palmen.supermarket.persistence.entity.ProductType;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class ProductInput {

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
