/**
 * Section 4
 *  Lecture 5: Flyway
 *  Car Repository class
 */
package com.ej.microservices;

import org.springframework.data.repository.CrudRepository;

/**
 * @author eunsoojung
 *
 */
public interface CarRepository extends CrudRepository<Car, Long> {
	
	Iterable<Car> findByMakeIgnoringCase(String make);
}
