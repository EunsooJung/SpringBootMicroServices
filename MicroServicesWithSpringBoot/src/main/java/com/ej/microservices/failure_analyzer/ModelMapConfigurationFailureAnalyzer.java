/**
 * 
 */
package com.ej.microservices.failure_analyzer;

import org.modelmapper.ConfigurationException;
import org.modelmapper.spi.ErrorMessage;
import org.springframework.boot.diagnostics.AbstractFailureAnalyzer;
import org.springframework.boot.diagnostics.FailureAnalysis;

/**
 * @author eunsoojung
 *
 */
public class ModelMapConfigurationFailureAnalyzer 
	extends AbstractFailureAnalyzer<ConfigurationException> {

	/* (non-Javadoc)
	 * @see org.springframework.boot.diagnostics.AbstractFailureAnalyzer#analyze(java.lang.Throwable, java.lang.Throwable)
	 */
	@Override
	protected FailureAnalysis analyze(Throwable rootFailure, ConfigurationException cause) {
		StringBuilder description = new StringBuilder();
		description.append("ModelMapper configuration failed:\n");
		for (ErrorMessage message : cause.getErrorMessages()) {
			description.append(message.getMessage());
		}
		return new FailureAnalysis(description.toString(),
				"Fix ModelMapper configuration", cause);
	}
	
	

}
