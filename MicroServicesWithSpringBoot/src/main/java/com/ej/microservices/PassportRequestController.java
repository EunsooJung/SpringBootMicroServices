/**
 * 
 */
package com.ej.microservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author eunsoojung
 *
 */
@RestController
public class PassportRequestController {
	
	@Autowired
	private IntegrationClient integrationClient;
	
	@RequestMapping("/{userId}/passport")
	Passport passport(@PathVariable String userId) {
		return new Passport(userId, 
				this.integrationClient.getContacts(userId),
				this.integrationClient.getBookmarks(userId));
	}

}
