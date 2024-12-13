package com.palmen.supermarket.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.palmen.supermarket.persistence.entity.Product;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {

}
