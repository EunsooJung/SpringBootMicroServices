/*
 * Master branch.
 */

package com.ej.microservices;


import java.security.Principal;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableResourceServer
@SpringBootApplication
// @EnableOAuth2Resource
@RestController
public class SsoReourceApplication {
	
	@RequestMapping("/hi")
	public Map<String, Object> hi(Principal principal) {
		System.out.println("recieved request from " + principal.getName());
		Map<String, Object> result = new HashMap<>();
		
		result.put("id", UUID.randomUUID().toString());
		result.put("content", "Hello, world!");
		
		return result;
	}

	public static void main(String[] args) {
		SpringApplication.run(SsoReourceApplication.class, args);
	}
	
}