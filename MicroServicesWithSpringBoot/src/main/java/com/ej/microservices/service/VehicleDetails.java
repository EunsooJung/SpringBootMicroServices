/**
 * 
 */
package com.ej.microservices.service;

import org.springframework.util.Assert;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author eunsoojung
 *
 */
public class VehicleDetails {
	
	private final String make;
	
	private final String model;
	
	@JsonCreator
	public VehicleDetails(@JsonProperty("make") String make, 
						  @JsonProperty("model") String model) {
		Assert.notNull(make, "Make must not be null!");
		Assert.notNull(model, "Model must not be null!");
		this.make = make;
		this.model = model;
	}

	/**
	 * @return the make
	 */
	public String getMake() {
		return make;
	}

	/**
	 * @return the model
	 */
	public String getModel() {
		return model;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return this.make.hashCode() * 31 +
				this.model.hashCode();
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
		VehicleDetails other = (VehicleDetails) obj;
		return this.make.equals(other.make) &&
				this.model.equals(other.model);
	}

}
