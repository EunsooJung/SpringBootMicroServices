/*
 * 
 */

package com.ej.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OperationsLoggingApplication {
	
	public static void main(String[] args) {
		
		SpringApplication myApplication = new SpringApplication(OperationsLoggingApplication.class);
		
		myApplication.setWebEnvironment(false);
		myApplication.run(args);
	}
	
}
