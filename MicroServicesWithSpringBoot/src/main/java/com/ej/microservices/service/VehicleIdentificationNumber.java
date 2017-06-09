/**
 * 
 */
package com.ej.microservices.service;

import org.springframework.util.Assert;

/**
 * @author eunsoojung
 *
 */
public class VehicleIdentificationNumber {
	
	private String vin;

	public VehicleIdentificationNumber(String vin) {
		Assert.notNull(vin, "VIN must not be null!");
		Assert.isTrue(vin.length() == 17, "VIN must be exactly 17 characters");
		this.vin = vin;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return this.vin.hashCode();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (obj == null || obj.getClass() != getClass()) {
			return false;
		}
		return this.vin.equals(((VehicleIdentificationNumber) obj).vin);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.vin;
	}

}
