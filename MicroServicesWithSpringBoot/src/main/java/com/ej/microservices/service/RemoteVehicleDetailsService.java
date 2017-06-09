/**
 * 
 */
package com.ej.microservices.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

/**
 * @author eunsoojung
 *
 */
@Service
public class RemoteVehicleDetailsService implements VehicleDetailsService {
	
	private static final Logger logger = LoggerFactory.getLogger(RemoteVehicleDetailsService.class);
	
	private final RemoteVehicleDetailsServiceProperties rvdsProperty;
	
	private final RestTemplate restTemplate;
	
	/**
	 * @param rvdsProperty
	 * @param restTemplate
	 */
	public RemoteVehicleDetailsService(RemoteVehicleDetailsServiceProperties rvdsProperty, RestTemplateBuilder restTemplateBuilder) {
		this.rvdsProperty = rvdsProperty;
		this.restTemplate = restTemplateBuilder.build();
	}



	/* (non-Javadoc)
	 * @see com.ej.microservices.service.VehicleDetailsService#getVehicleDetails(com.ej.microservices.service.VehicleIdentificationNumber)
	 */
	@Override
	public VehicleDetails getVehicleDetails(VehicleIdentificationNumber vin)
			throws VehicleIdentificationNumberNotFoundException {
		Assert.notNull(vin, "VIN must not be null!");
		String url = this.rvdsProperty.getRootUrl() + "vehicle/{vin}/details";
		logger.debug("Retrieving vehicle data for: " + vin + " from: " + url);
		
		try {
			return this.restTemplate.getForObject(url, VehicleDetails.class, vin);
		} catch (HttpStatusCodeException ex) {
			if (HttpStatus.NOT_FOUND.equals(ex.getStatusCode())) {
				throw new VehicleIdentificationNumberNotFoundException(vin, ex);
			}
			throw ex;
		}
	}
}