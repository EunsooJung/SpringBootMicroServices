/**
 * 
 */
package com.ej.microservices;

import org.springframework.stereotype.Service;

/**
 * @author eunsoojung
 *
 */
@Service
class EchoService {
	
	public String echo(String input) {
		return "Echo: " + input;
	}
}
