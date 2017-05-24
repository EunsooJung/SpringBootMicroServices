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
public class ExampleMetricController {
	
	private final ExampleService service;
	
	public ExampleMetricController(ExampleService service) {
		this.service = service;
	}
	
	@RequestMapping("/")
	public String hello() {
		this.service.call();
		return "Hello World!";
	}

}
