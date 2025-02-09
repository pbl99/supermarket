package com.palmen.supermarket.persistence.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.palmen.supermarket.dto.ProductFilterDTO;
import com.palmen.supermarket.persistence.entity.Product;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {

	List<Product> findByBrand_Name(String brandName);
	List<Product> findByCategory_Name(String category);
	
	/*@Query("SELECT * FROM PRODUCTS WHERE")
	List<Product> findByFilters(ProductFilterDTO productFilterDTO);*/
}
