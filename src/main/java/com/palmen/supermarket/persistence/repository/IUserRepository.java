package com.palmen.supermarket.persistence.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.palmen.supermarket.persistence.entity.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
	Optional<User> findByUsername(String username);
}
