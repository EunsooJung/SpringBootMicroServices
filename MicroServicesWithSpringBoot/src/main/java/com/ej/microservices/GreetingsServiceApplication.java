/*
 */

package com.ej.microservices;


import java.security.Principal;
import java.util.Collections;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@EnableResourceServer
@SpringBootApplication
@RestController
public class GreetingsServiceApplication {
	
	@RequestMapping(method = RequestMethod.GET, value = "/hi")
	public Map<String, String> greetings(Principal p) {
		return Collections.singletonMap("content", "Hello, " + p.getName());
	}

	public static void main(String[] args) {
		SpringApplication.run(GreetingsServiceApplication.class, args);
	}
	
}