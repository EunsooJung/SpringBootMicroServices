/**
 * 
 */
package com.ej.microservices.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author eunsoojung
 *
 */
@Entity
public class Account {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String username, passowrd;
	private boolean active;
	
	public Account() {
		// why JPA why ?
	}

	public Account(String username, String passowrd, boolean active) {
		this.username = username;
		this.passowrd = passowrd;
		this.active = active;
	}

	public Long getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getPassowrd() {
		return passowrd;
	}

	public boolean isActive() {
		return active;
	}

}
