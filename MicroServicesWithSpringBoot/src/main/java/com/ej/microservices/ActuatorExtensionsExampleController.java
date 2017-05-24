/**
 * Lecture 7.3.1 Introduce the Spring Boot Actuator (Extending Actuator)
 */
package com.ej.microservices;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author eunsoojung
 * 
 */
@RestController
public class ActuatorExtensionsExampleController {
	
	@RequestMapping("/")
	public String hello() {
		return "Hello World!";
	}
}
