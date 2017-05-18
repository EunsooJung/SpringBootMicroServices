/*
 * Section 5
 *  Lecture 5.5 Use Hypermedia example tutorial
 */

package com.ej.microservices;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MicroServicesWithSpringBootApplication {
	
	@Bean
	CommandLineRunner commandLineRunner(PersonRepository personRepository) {
		return args -> {
			Arrays.asList("Phil", "Josh").forEach(name -> personRepository
					.save(new Person(name, (name + "@email.com").toLowerCase())));
			personRepository.findAll().forEach(System.out::println);
		};
	}
	
	public static void main(String[] args) {
		SpringApplication.run(MicroServicesWithSpringBootApplication.class, args);
	}
	
}