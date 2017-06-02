package com.ej.microservices.services;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ej.microservices.model.Account;

interface AccountRepository extends JpaRepository<Account, Long> {
	Optional<Account> findByUsername(String username);
}
