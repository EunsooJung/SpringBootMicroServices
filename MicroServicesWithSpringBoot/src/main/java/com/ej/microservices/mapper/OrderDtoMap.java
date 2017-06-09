/**
 * 
 */
package com.ej.microservices.mapper;

import org.springframework.stereotype.Component;

/**
 * @author eunsoojung
 *
 */
@Component
public class OrderDtoMap extends PropertyMap<Order, OrderDto> {
	
	@Override
	protected void configure() {
		map().setBillingStreet(this.source.getBillingAddress().getStreet());
		map().setBillingCity("REDACTED");
		// Uncomment this to cause failure: map().setBillingCity("Will break");
	}

}
