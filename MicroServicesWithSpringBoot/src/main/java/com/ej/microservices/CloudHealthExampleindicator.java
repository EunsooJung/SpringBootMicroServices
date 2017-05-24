/**
 * 
 */
package com.ej.microservices;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Status;
import org.springframework.boot.actuate.health.Health.Builder;
import org.springframework.stereotype.Component;

/**
 * @author eunsoojung
 *
 */
@Component
public class CloudHealthExampleindicator extends AbstractHealthIndicator {
	
	private boolean up = true;
	
	public void setup(boolean up) {
		this.up = up;
	}

	@Override
	protected void doHealthCheck(Builder builder) throws Exception {
		builder.status(this.up ? Status.UP : Status.DOWN);
	}
}
