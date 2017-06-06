/**
 * 
 */
package com.ej.microservices.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author eunsoojung
 *
 */

@Component
@ConfigurationProperties(prefix = "vehicle.service")
public class RemoteVehicleDetailsServiceProperties {
	
	private String rootUrl = "http://localhost:8081/vs/";
	
	public String getRootUrl() {
		return this.rootUrl;
	}
	
	public void setRootUrl(String vehicleServiceRootUrl) {
		this.rootUrl = vehicleServiceRootUrl;
	}

}
