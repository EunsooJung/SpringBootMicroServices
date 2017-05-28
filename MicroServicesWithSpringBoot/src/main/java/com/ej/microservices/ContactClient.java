/**
 * 
 */
package com.ej.microservices;

import java.util.Collection;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author eunsoojung
 *
 */
@FeignClient("contact-service")
public interface ContactClient {
	
	@RequestMapping(method = RequestMethod.GET, value = "/{userId}/contacts")
	Collection<Contact> getContacts(@PathVariable("userI") String userID);
}
