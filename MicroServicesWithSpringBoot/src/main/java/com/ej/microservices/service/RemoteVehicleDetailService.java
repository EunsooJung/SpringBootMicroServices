/**
 * 
 */
package com.ej.microservices.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import com.ej.microservices.config.RemoteVehicleDetailsServiceProperties;
import com.ej.microservices.domain.VehicleDetails;
import com.ej.microservices.domain.VehicleIdentificationNumber;
import com.ej.microservices.exception.VehicleIdentificationNumberNotFoundException;

/**
 * @author eunsoojung
 *
 */
public class RemoteVehicleDetailService implements VehicleDetailsService {
	
	private static final Logger logger = LoggerFactory.getLogger(RemoteVehicleDetailService.class);
	
	private final RemoteVehicleDetailsServiceProperties rvdsProperties;
	
	private final RestTemplate restTemplate;
	
	
	
	
	public RemoteVehicleDetailService(RemoteVehicleDetailsServiceProperties rvdsProperties, RestTemplate restTemplate) {
		this.rvdsProperties = rvdsProperties;
		this.restTemplate = restTemplate;
	}

	/* (non-Javadoc)
	 * @see com.ej.microservices.service.VehicleDetailsService#getVehicleDetails(com.ej.microservices.domain.VehicleIdentificationNumber)
	 */
	@Override
	public VehicleDetails getVehicleDetails(VehicleIdentificationNumber vin)
			throws VehicleIdentificationNumberNotFoundException {
		Assert.notNull(vin, "VIN must not be null");
		String url = this.rvdsProperties.getRootUrl() + "vehicle/{vin}/details";
		logger.debug("Retrieving vehicle data for: " + vin + " from: " + url);
		try {
			return this.restTemplate.getForObject(url, VehicleDetails.class, vin);
		} catch(HttpStatusCodeException ex) {
			if (HttpStatus.NOT_FOUND.equals(ex.getStatusCode())) {
				throw new VehicleIdentificationNumberNotFoundException(vin, ex);
			}
			throw ex;
		}
	}
}
