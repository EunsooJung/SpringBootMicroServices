/**
 * 
 */
package com.ej.microservices;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author eunsoojung
 *
 */
public interface CarRepository extends ElasticsearchRepository<Car, Long> {
	Iterable<Car> findByMakeIgnoreCase(String make);
}
