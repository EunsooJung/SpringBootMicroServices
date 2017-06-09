/**
 * 
 */
package com.ej.microservices.mapper;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.springframework.beans.factory.UnsatisfiedDependencyException;
import org.springframework.boot.builder.SpringApplicationBuilder;

import com.ej.microservices.ExtendingSpringBootApplication;

/**
 * @author eunsoojung
 *
 */
public class MapperDisabledIntegrationTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void modelMapperRuns() throws Exception {
		this.thrown.expect(UnsatisfiedDependencyException.class);
		this.thrown.expectMessage("ModelMapper");
		new SpringApplicationBuilder(ExtendingSpringBootApplication.class)
				.properties("modelmapper.enabled=false").run();
	}

}
