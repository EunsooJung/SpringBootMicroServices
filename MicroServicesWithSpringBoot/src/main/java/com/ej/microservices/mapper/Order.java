/**
 * 
 */
package com.ej.microservices.mapper;

/**
 * @author eunsoojung
 *
 */
public class Order {
	
	private Customer customer;

	private Address billingAddress;

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Address getBillingAddress() {
		return this.billingAddress;
	}

	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}

}
