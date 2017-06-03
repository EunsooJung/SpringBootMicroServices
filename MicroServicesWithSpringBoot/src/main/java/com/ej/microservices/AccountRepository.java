/**
 * 
 */
package com.ej.microservices;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author eunsoojung
 *
 */
interface AccountRepository extends JpaRepository<Account, Long> {
	Optional<Account> findByUsername(String username);
}
