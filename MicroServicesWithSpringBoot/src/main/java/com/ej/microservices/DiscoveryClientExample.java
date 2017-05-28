/**
 * 
 */
package com.ej.microservices;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author eunsoojung
 *
 */
@Order(1)
@Component
public class DiscoveryClientExample implements CommandLineRunner {
	
	private final DiscoveryClient discoveryClient;
	
	public DiscoveryClientExample (DiscoveryClient discoveryClient) {
		this.discoveryClient = discoveryClient;
	}

	@Override
	public void run(String... args) throws Exception {
		this.discoveryClient.getInstances("contact-service")
		.forEach((ServiceInstance s) -> {
			System.out.println(ToStringBuilder.reflectionToString(s));
		});
	}
}
