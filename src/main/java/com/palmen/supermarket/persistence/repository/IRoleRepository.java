package com.palmen.supermarket.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.palmen.supermarket.persistence.entity.Role;

@Repository
public interface IRoleRepository extends JpaRepository<Role, Long>{

}
