package com.palmen.supermarket.persistence.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.palmen.supermarket.persistence.entity.Brand;

@Repository
public interface IBrandRepository extends JpaRepository<Brand, Long> {

	Optional<Brand> findByName(String name);
}
