/**
 * 
 */
package com.ej.microservices;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author eunsoojung
 *
 */

public interface ContactRepository extends JpaRepository<Contact, Long> {

	List<Contact> findByUserId(String userId);

	Contact findByUserIdAndId(String userId, Long id);

}
