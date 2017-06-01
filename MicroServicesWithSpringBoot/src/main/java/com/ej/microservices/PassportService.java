/**
 * 
 */
package com.ej.microservices;

import org.reactivestreams.Subscriber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import reactor.Environment;
import reactor.rx.Stream;
import reactor.rx.Streams;

/**
 * @author eunsoojung
 *
 */
@Component
public class PassportService {
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private ContactClient contactClient;
	
	@Autowired
	private BookmarkClient bookmarkClient;
	
	public Stream<Bookmark> getBookmarks(String userId) {
		return Streams.<Bookmark>create(subscriber -> { 
			this.bookmarkClient.getBookmarks(userId).forEach(subscriber::onNext);
			subscriber.onComplete();
		}).dispatchOn(this.environment, Environment.cachedDispatcher()).log("bookmarks");
	}
	
	public Stream<Contact> getContacts(String userId) {
		return Streams.<Contact>create(subscriver -> {
			this.contactClient.getContacts(userId).forEach(subscriver::onNext);
			subscriver.onComplete();
		}).dispatchOn(this.environment, Environment.cachedDispatcher()).log("contacts");
	}
	
	public Stream<Passport> getPassports(
			String userId,
			Stream<Contact> contacts,
			Stream<Bookmark> bookmarks) {
		return Streams.zip(
				contacts.buffer(),
				bookmarks.buffer(),
				tuple -> new Passport(userId, tuple.getT1(), tuple.getT2()));
	}

}
