/**
 * 
 */
package com.ej.microservices;

import java.security.Principal;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author eunsoojung
 *
 */
@Configuration
@RestController
@EnableResourceServer
public class PrincipalRestController extends ResourceServerConfigurerAdapter {

	/* (non-Javadoc)
	 * @see org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter#configure(org.springframework.security.config.annotation.web.builders.HttpSecurity)
	 */
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http
			.antMatcher("/hi")
			.authorizeRequests().anyRequest().authenticated();
	}
	
	@RequestMapping("/user")
	Principal principal(Principal p) {
		return p;
	}
	
	
}
