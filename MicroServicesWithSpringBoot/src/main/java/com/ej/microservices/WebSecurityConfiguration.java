/**
 * 
 */
package com.ej.microservices;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

/**
 * @author eunsoojung
 *
 */
@Configuration
@EnableOAuth2Sso
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

	/* (non-Javadoc)
	 * @see org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter#configure(org.springframework.security.config.annotation.web.builders.HttpSecurity)
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.antMatcher("/**")
		.authorizeRequests()
		.antMatchers("/","/login**","/webjars**").permitAll()
		.anyRequest().authenticated()
		.and()
		.logout().logoutSuccessUrl("/").permitAll()
		.and()
		.csrf().csrfTokenRepository(
				CookieCsrfTokenRepository.withHttpOnlyFalse());
	}
}
