/**
 * 
 */
package com.ej.microservices.controller;

import java.security.Principal;
import java.util.Collections;
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
public class GreetingRestController {
	
	@RequestMapping("/hi")
	public Map<String, Object> hi(Principal principal) {
		Map<String, Object> result = new HashMap<>();
		result.put("id", UUID.randomUUID().toString());
		result.put("content","Hello, " + principal.getName());
		return result;
	}

}
