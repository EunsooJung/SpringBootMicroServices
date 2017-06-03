/*
 */

package com.ej.microservices;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.resource.UserInfoRestTemplateFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;

@SpringBootApplication
public class EdgeServiceApplication {
	
	@Bean
	OAuth2RestTemplate restTemplate(UserInfoRestTemplateFactory templateFacotry) {
		return templateFacotry.getUserInfoRestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(EdgeServiceApplication.class, args);
	}
	
}