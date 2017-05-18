/*
 * Section 5
 *  Lecture 5.5 Use Hypermedia example tutorial
 */

package com.ej.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.config.EnableIntegration;

/**
 * the goal here is to demonstrate that Spring Integration can act as a processor for a
 * <EM>lot</EM> of different types of services.
 */

@SpringBootApplication
@EnableIntegration
@IntegrationComponentScan
public class MicroServicesWithSpringBootApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(MicroServicesWithSpringBootApplication.class, args);
	}
	
}