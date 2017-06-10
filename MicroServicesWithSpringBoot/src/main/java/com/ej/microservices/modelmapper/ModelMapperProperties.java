/**
 * 
 */
package com.ej.microservices.modelmapper;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author eunsoojung
 *
 */
@ConfigurationProperties(prefix = "modelmapper")
public class ModelMapperProperties {
	
	private boolean enabled = true;
	
	private boolean addMapping = true;
	
	private boolean addConverters = true;

	/**
	 * @return the enabled
	 */
	public boolean isEnabled() {
		return enabled;
	}

	/**
	 * @param enabled the enabled to set
	 */
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	/**
	 * @return the addMapping
	 */
	public boolean isAddMapping() {
		return addMapping;
	}

	/**
	 * @param addMapping the addMapping to set
	 */
	public void setAddMapping(boolean addMapping) {
		this.addMapping = addMapping;
	}

	/**
	 * @return the addConverters
	 */
	public boolean isAddConverters() {
		return addConverters;
	}

	/**
	 * @param addConverters the addConverters to set
	 */
	public void setAddConverters(boolean addConverters) {
		this.addConverters = addConverters;
	}

}
