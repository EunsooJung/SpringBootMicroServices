/**
 * 
 */
package com.ej.microservices;

import java.util.Collection;

/**
 * @author eunsoojung
 *
 */
public class Passport {
	
	private String userId;
	private Collection<Contact> contacts;
	private Collection<Bookmark> bookmarks;
	
	public Passport(String userID,
			Collection<Contact> contacts,
			Collection<Bookmark> bookmarks) {
		this.userId = userId;
		this.contacts = contacts;
		this.bookmarks = bookmarks;
	}

	public String getUserId() {
		return userId;
	}

	public Collection<Contact> getContacts() {
		return contacts;
	}

	public Collection<Bookmark> getBookmarks() {
		return bookmarks;
	}

	@Override
	public String toString() {
		return "Passport{" + "userId='" + userId + '\'' + ", bookmarks=" + bookmarks
				+ ", contacts=" + contacts + '}';
	}
}
