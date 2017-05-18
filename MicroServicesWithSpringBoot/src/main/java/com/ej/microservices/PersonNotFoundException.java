/**
 * 
 */
package com.ej.microservices;

/**
 * @author eunsoojung
 *
 */
public class PersonNotFoundException extends RuntimeException {
	private Long personId;
	
	public Long getPersonId() {
		return personId;
	}
	
	public PersonNotFoundException(Long personId) {
		super("person#" + personId + " was not found");
		this.personId = personId;
	}
}
