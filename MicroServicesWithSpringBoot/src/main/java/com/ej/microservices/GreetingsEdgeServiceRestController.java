/**
 * 
 */
package com.ej.microservices;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author eunsoojung
 *
 */
@RestController
public class GreetingsEdgeServiceRestController {
	
	private final RestTemplate restTemplate;
	
	@Autowired
	public GreetingsEdgeServiceRestController(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/hi")
	public Map<String, String> greet() {
		return this.restTemplate.exchange(
				"http://localhost:8080/hi",
				HttpMethod.GET, null, 
				new ParameterizedTypeReference<Map<String, String>>() {
				})
				.getBody();
	}
	
}
