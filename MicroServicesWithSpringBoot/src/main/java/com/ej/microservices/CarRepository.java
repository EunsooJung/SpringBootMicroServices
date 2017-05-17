/**
 *  Spring Data REST
 */
package com.ej.microservices;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

/**
 * @author eunsoojung
 *
 */
public interface CarRepository extends CrudRepository<Car, Long> {
	
	@RestResource(path = "find")
	Iterable<Car> findByMakeIgnoringCase(@Param("make") String make);

}
