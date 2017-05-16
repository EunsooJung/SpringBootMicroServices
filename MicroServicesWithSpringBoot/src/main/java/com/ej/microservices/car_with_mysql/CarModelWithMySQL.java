/**
 * 
 */
package com.ej.microservices.car_with_mysql;

/**
 * @author eunsoojung
 *
 */
public class CarModelWithMySQL {
	
	private long id;

	private String make;

	private String model;

	private int year;

	public CarModelWithMySQL(long id, String make, String model, int year) {
		this.id = id;
		this.make = make;
		this.model = model;
		this.year = year;
	}

	long getId() {
		return id;
	}

	public String getMake() {
		return make;
	}

	public String getModel() {
		return model;
	}

	public int getYear() {
		return year;
	}

	@Override
	public String toString() {
		return make + " " + model + " " + year;
	}


}
