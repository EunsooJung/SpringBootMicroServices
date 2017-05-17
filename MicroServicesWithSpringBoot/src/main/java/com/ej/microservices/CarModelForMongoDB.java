/**
 * 4.6 MongoDB Car model class
 */
package com.ej.microservices;

import java.math.BigInteger;

import org.springframework.data.annotation.Id;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author eunsoojung
 *
 */

@Document
public class CarModelForMongoDB {
	
	@Id
	private BigInteger id;
	
	private String make;
	
	private String model;
	
	private int year;
	
	@GeoSpatialIndexed(name = "position")
	private Point position;
	
	CarModelForMongoDB() {
		
	}

	public CarModelForMongoDB(String make, String model, int year, Point position) {
		super();
		this.make = make;
		this.model = model;
		this.year = year;
		this.position = position;
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

	@Override
	public String toString() {
		return "Car [make=" + make + ", model=" + model + ", year=" + year + "]";
	}
}
