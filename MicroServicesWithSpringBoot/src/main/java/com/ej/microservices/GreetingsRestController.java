/**
 * 
 */
package com.ej.microservices;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author eunsoojung
 *
 */
@RestController
public class GreetingsRestController {
	// version 2.0
	@RequestMapping("/hi")
	public Map<String, Object> hi(Principal principal) {
		Map<String, Object> result = new HashMap<>();
		result.put("id", UUID.randomUUID().toString());
		result.put("content", "Hello, " + principal.getName());
		return result;
	}
	
	/*// version 1.0
	@RequestMapping("/hi")
	public Map<String, Object> hi() {
		Map<String, Object> result = new HashMap<>();
		result.put("id", UUID.randomUUID().toString());
		result.put("content", "Hello, world!");
		return result;
	}*/
}
