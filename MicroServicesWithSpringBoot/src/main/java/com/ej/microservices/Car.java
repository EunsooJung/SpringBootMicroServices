/**
 * Car model for Elasticsearch
 */
package com.ej.microservices;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @author eunsoojung
 *
 */
@Document(indexName = "car", type = "car", shards = 1, replicas = 0, refreshInterval = "-1")
public class Car {
	
	@Id
	private Long id;
	private String make;
	private String model;
	private int year;
	
	Car() {
	}

	public Car(String make, String model, int year) {
		super();
		this.make = make;
		this.model = model;
		this.year = year;
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
