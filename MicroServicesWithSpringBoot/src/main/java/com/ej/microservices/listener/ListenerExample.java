/**
 * 
 */
package com.ej.microservices.listener;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author eunsoojung
 *
 */
@Component
public class ListenerExample {
	
	@Value("${example.secret")
	private String secret;
	
	@PostConstruct
	public void print() {
		System.err.println(this.secret);
	}

}
