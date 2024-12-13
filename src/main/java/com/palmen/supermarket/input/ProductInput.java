package com.palmen.supermarket.input;

import lombok.Data;

@Data
public class ProductInput {

	private String name;
	private String description;
	private Double weight;
	private String imageUrl;
	private String brandName;
	private String categoryName;
}
