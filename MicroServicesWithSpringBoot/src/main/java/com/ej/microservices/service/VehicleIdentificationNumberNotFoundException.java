/**
 * 
 */
package com.ej.microservices.service;

/**
 * @author eunsoojung
 *
 */
public class VehicleIdentificationNumberNotFoundException extends RuntimeException {
	
	private VehicleIdentificationNumber vehicleIdentificationNumber;
	
	public VehicleIdentificationNumberNotFoundException(VehicleIdentificationNumber vin) {
		this(vin, null);
	}

	/**
	 * @param vehicleIdentificationNumber
	 */
	public VehicleIdentificationNumberNotFoundException(VehicleIdentificationNumber vin, 
			Throwable cause) {
		super("Unable to find VehicleIdentificationNumber" + vin, cause);
		this.vehicleIdentificationNumber = vin;
	}
	
	public VehicleIdentificationNumber getVehicleIdentificationNumber() {
		return this.vehicleIdentificationNumber;
	}
	

}
