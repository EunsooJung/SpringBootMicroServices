/**
 * Lecture 5.5 Use Hypermedia example tutorial
 */
package com.ej.microservices;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author eunsoojung
 *
 */
@Entity
public class Person {
	
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String email;
	
	Person() {
	}

	public Person(String name, String email) {
		this.name = name;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name='" + name + '\'' + ", email=" + email + '\'' + "]";
	}
	
	

}
