/**
 * 
 */
package com.ej.microservices;

import org.springframework.boot.actuate.health.OrderedHealthAggregator;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

/**
 * @author eunsoojung
 *
 */
@Component
public class HealthAgregatorExample extends OrderedHealthAggregator {
	
	public HealthAgregatorExample() {
		setStatusOrder(Status.OUT_OF_SERVICE, Status.DOWN, Status.UP, Status.UNKNOWN);
	}
}
