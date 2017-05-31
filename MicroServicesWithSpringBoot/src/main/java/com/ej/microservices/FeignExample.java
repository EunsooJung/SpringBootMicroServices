/**
 * 
 */
package com.ej.microservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author eunsoojung
 *
 */
/*
@Order(3)
@Component
public class FeignExample implements CommandLineRunner {

	@Autowired
	private ContactClient contactClient;

	@Autowired
	private BookmarkClient bookmarkClient;

	@Override
	public void run(String... strings) throws Exception {
		this.bookmarkClient.getBookmarks("jlong").forEach(System.out::println);
		this.contactClient.getContacts("jlong").forEach(System.out::println);
	}

}
*/

@Order(3)
@Component
public class FeignExample implements CommandLineRunner {
	
	private final ContactClient contactClient;
	
	private final BookmarkClient bookmarkClient;

	public FeignExample(ContactClient contactClient, BookmarkClient bookmarkClient) {
		this.contactClient = contactClient;
		this.bookmarkClient = bookmarkClient;
	}

	@Override
	public void run(String... args) throws Exception {
		
		this.bookmarkClient.getBookmarks("jlog").forEach(System.out::println);
		this.contactClient.getContacts("jlog").forEach(System.out::println);
		
	}
	
}
