/**
 * 
 */
package com.ej.microservices;

import java.security.Principal;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author eunsoojung
 *
 */
@RestController
public class PrincipalRestController {
	
	@RequestMapping("/user")
	public Principal principal(Principal p) {
		return p;
	}
}
