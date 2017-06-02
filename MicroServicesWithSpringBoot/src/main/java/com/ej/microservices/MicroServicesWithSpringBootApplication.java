/*
 * Lecture 10.3 Understand x509
 */

package com.ej.microservices;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;


@SpringBootApplication
public class MicroServicesWithSpringBootApplication extends WebSecurityConfigurerAdapter {

	public static void main(String[] args) {
		SpringApplication.run(MicroServicesWithSpringBootApplication.class, args);
	}
	
	private final AccountUserDetailsService accountUserDetailsService;
	
	@Autowired
	public MicroServicesWithSpringBootApplication(AccountUserDetailsService accountUserDetailsService) {
		this.accountUserDetailsService = accountUserDetailsService;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().anyRequest().authenticated()
		.and()
			.x509()
		.and()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.NEVER)
		.and()
			.csrf().disable();
	}
	
}