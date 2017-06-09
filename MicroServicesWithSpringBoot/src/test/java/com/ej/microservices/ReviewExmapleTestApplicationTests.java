/*
 * S11-L11.3 Testing with Spring
 */

package com.ej.microservices;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.ej.microservices.domain.VehicleIdentificationNumber;
import com.ej.microservices.service.VehicleDetails;
import com.ej.microservices.service.VehicleDetailsService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase
public class ReviewExmapleTestApplicationTests {
	
	private static final VehicleIdentificationNumber VIN = new VehicleIdentificationNumber("01234567890123456");
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@MockBean
	private VehicleDetailsService vehicleDetailsService;
	
	@Before
	public void setup() {
		given(this.vehicleDetailsService.getVehicleDetails(VIN))
		.willReturn(new VehicleDetails("Honda", "Civic"));
	}
	
	@Test
	public void test() {
		ResponseEntity<String> response = this.restTemplate
				.getForEntity("/{username}/vehicle}", String.class, "mickey");
		assertThat(response.getBody().contains("Honda"));
	}

}
