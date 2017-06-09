/**
 * 
 */
package com.ej.microservices.service;

/**
 * @author eunsoojung
 *
 */
public interface VehicleDetailsService {
	
	VehicleDetails getVehicleDetails(VehicleIdentificationNumber vin)
	
		throws VehicleIdentificationNumberNotFoundException;

}
