/*
 * 
 */

package com.ej.microservices;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ej.microservices.car_with_mysql.CarModelWithMySQLRepository;

@SpringBootApplication
public class MicroServicesWithSpringBootApplication {
	
	@Bean
	public CommandLineRunner exampleQuery(CarModelWithMySQLRepository repository) {
		return args -> repository.findByMakeIgnoringCase("HONDA")
				.forEach(System.err::println);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(MicroServicesWithSpringBootApplication.class, args);
	}
	
}