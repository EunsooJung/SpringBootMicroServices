/**
 * 
 */
package com.ej.microservices;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author eunsoojung
 * 
 */
@RestController
public class ActuatorExampleController {
	
	@RequestMapping("/")
	public String hello() {
		return "Hello World!";
	}

}