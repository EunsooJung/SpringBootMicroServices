/**
 * 
 */
package com.ej.microservices.car;

import org.springframework.data.repository.CrudRepository;

/**
 * @author eunsoojung
 *
 */
public interface CarRepository extends CrudRepository<Car, Long> {
	
	Iterable<Car> findByMakeIgnoringCase(String make);

}
