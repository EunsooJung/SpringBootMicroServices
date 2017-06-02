/**
 * 
 */
package com.ej.microservices;

import java.security.Principal;
import java.util.Collections;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author eunsoojung
 *
 */
@RestController
class GreetingRestController {
	
	@RequestMapping(method = RequestMethod.GET, value = "/hi")
	public Map<String, String> greetings(Principal p) {
		return Collections.singletonMap("content",  "Hello, " + p.getName());
	}
}
