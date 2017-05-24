/*
 * Lecture 7.6 Measure anything and everything with metrics
 */

package com.ej.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.metrics.rich.InMemoryRichGaugeRepository;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

@SpringBootApplication
public class MicroServicesWithSpringBootApplication {
	
	@Bean
	@Primary
	public InMemoryRichGaugeRepository inMemoryRichGaugeRepository() {
		return new InMemoryRichGaugeRepository();
	}

	public static void main(String[] args) {
		SpringApplication.run(MicroServicesWithSpringBootApplication.class, args);
	}
} 