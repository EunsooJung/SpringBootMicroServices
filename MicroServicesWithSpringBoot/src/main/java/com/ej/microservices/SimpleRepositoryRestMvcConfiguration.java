/**
 * 
 */
package com.ej.microservices;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

/**
 * @author eunsoojung
 *
 */
@Configuration
public class SimpleRepositoryRestMvcConfiguration extends RepositoryRestMvcConfiguration {
	
	// @Override
	protected void configureRepositoryRestConfiguration(
			RepositoryRestConfiguration config) {
		config.exposeIdsFor(Person.class);
	}

}
