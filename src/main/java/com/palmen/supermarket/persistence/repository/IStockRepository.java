package com.palmen.supermarket.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.palmen.supermarket.persistence.entity.Stock;

@Repository
public interface IStockRepository extends JpaRepository<Stock, Long> {

}
