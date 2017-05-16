/**
 * Section 4
 *  Lecture 5: Flyway
 *  Model class
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
public class Car {
	
	@Id
	@GeneratedValue
	private long id;
	
	private String make;
	
	private String model;
	
	private int year;
	
	private String color;
	
	Car() {
		
	}

	public Car(String make, String model, int year, String color) {
		super();
		this.make = make;
		this.model = model;
		this.year = year;
		this.color = color;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Car [make=" + make + ", model=" + model + ", year=" + year + ", color=" + this.color + "]";
	}
	
	

}
