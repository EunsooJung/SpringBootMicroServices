/**
 * 
 */
package com.ej.microservices.listener;

import java.util.Collections;

import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.PropertySource;

/**
 * @author eunsoojung
 *
 */
public class ExampleApplicationListener implements ApplicationListener<ApplicationEnvironmentPreparedEvent> {

	/* (non-Javadoc)
	 * @see org.springframework.context.ApplicationListener#onApplicationEvent(org.springframework.context.ApplicationEvent)
	 */
	@Override
	public void onApplicationEvent(ApplicationEnvironmentPreparedEvent event) {
		System.err.println("Adding extra properties");
		PropertySource<?> propertySource = new MapPropertySource(
				"example", 
				Collections.singletonMap("example.secret", "the-secret-key"));
		event.getEnvironment().getPropertySources().addFirst(propertySource);
	}
	
	

}
