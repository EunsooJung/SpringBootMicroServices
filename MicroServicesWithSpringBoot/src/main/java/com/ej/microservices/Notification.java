/**
 * 
 */
package com.ej.microservices;

import java.io.Serializable;
import java.util.Date;

/**
 * @author eunsoojung
 *
 */
public class Notification implements Serializable {
	
	private String id;
	private final String message;
	private final Date date;
	
	public Notification(String id, String message, Date date) {
		this.id = id;
		this.message = message;
		this.date = date;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public Date getDate() {
		return date;
	}

	@Override
	public String toString() {
		return "Notification [message=" + message + ", date=" + date + "]";
	}
}
