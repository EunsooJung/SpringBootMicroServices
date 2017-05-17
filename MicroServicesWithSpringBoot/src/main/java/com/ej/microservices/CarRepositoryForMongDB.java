/**
 * 
 */
package com.ej.microservices;

import org.springframework.data.geo.Distance;
import org.springframework.data.geo.GeoResults;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author eunsoojung
 *
 */
public interface CarRepositoryForMongDB extends MongoRepository<CarModelForMongoDB, Long> {
	Iterable<CarModelForMongoDB> findByMakeIgnoringCase(String make);
	GeoResults<CarModelForMongoDB> findByPositionNear(Point p, Distance d);
}
