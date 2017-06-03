package com.ej.microservices.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableGlobalAuthentication
public class SecurityConfig extends GlobalAuthenticationConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;
	
	/* (non-Javadoc)
	 * @see org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter#init(org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder)
	 */
	@Override
	public void init(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(this.userDetailsService);
	}
	

}
