/**
 * 
 */
package com.ej.microservices.mapper;

/**
 * @author eunsoojung
 *
 */
public class OrderDto {
	
	private String customerFirstName;

	private String customerLastName;

	private String billingStreet;

	private String billingCity;

	public String getCustomerFirstName() {
		return this.customerFirstName;
	}

	public void setCustomerFirstName(String customerFirstName) {
		this.customerFirstName = customerFirstName;
	}

	public String getCustomerLastName() {
		return this.customerLastName;
	}

	public void setCustomerLastName(String customerLastName) {
		this.customerLastName = customerLastName;
	}

	public String getBillingStreet() {
		return this.billingStreet;
	}

	public void setBillingStreet(String billingStreet) {
		this.billingStreet = billingStreet;
	}

	public String getBillingCity() {
		return this.billingCity;
	}

	public void setBillingCity(String billingCity) {
		this.billingCity = billingCity;
	}

	@Override
	public String toString() {
		return getCustomerFirstName() + " " + getCustomerLastName() + " - "
				+ getBillingStreet() + ", " + getBillingCity();
	}

}
