/**
 * 
 */
package com.ej.microservices.cotroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author eunsoojung
 *
 */
@RestController
public class HelloWorld {
	
	@RequestMapping("/")
	public String hello() {
		return "Hello World!ßß";
	}
}
