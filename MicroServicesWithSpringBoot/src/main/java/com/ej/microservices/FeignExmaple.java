/**
 * 
 */
package com.ej.microservices;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author eunsoojung
 *
 */
@Order(3)
@Component
public class FeignExmaple implements CommandLineRunner {
	
	private final ContactClient contactClient;
	
	private final BookmarkClient bookmarkClient;

	public FeignExmaple(ContactClient contactClient, BookmarkClient bookmarkClient) {
		this.contactClient = contactClient;
		this.bookmarkClient = bookmarkClient;
	}

	@Override
	public void run(String... args) throws Exception {
		
		this.bookmarkClient.getBookmarks("jlog").forEach(System.out::println);
		this.contactClient.getContacts("jlog").forEach(System.out::println);
		
	}
	
}
