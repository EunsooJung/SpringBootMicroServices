/*
 * ref.: https://github.com/livelessons-spring/building-microservices/blob/master/livelessons-data/livelessons-data-jdbc/src/main/java/demo/DataJdbcApplication.java
 */

package com.ej.microservices;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class MicroServicesWithSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroServicesWithSpringBootApplication.class, args);
	}
	
}