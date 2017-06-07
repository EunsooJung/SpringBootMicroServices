/*
 * Without Spring
 */
package com.ej.microservices.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyString;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.ej.microservices.domain.User;
import com.ej.microservices.domain.UserRepository;
import com.ej.microservices.domain.VehicleDetails;
import com.ej.microservices.domain.VehicleIdentificationNumber;
import com.ej.microservices.exception.UserNameNotFoundException;

public class UserVehicleServiceTest {

	private static final VehicleIdentificationNumber VIN = new VehicleIdentificationNumber(
			"01234567890123456");
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Mock
	private VehicleDetailsService vehicleDetailsService;
	
	@Mock
	private UserRepository userRepository;
	
	private UserVehicleService service;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		this.service = new UserVehicleService(
				this.userRepository, 
				this.vehicleDetailsService);
	}
	
	@Test
	public void getVehicleDetailsWhenUsernameIsNullShouldThrowException() 
		throws Exception {
		this.thrown.expect(IllegalArgumentException.class);
		this.thrown.expectMessage("Username must not be null");
		this.service.getVehicleDetails(null);
	}
	
	@Test
	public void getVehicleDetailsWhenUsernameNotFoundShouldThrowException() 
		throws Exception {
		given(this.userRepository.findByUsername(anyString())).willReturn(null);
		this.thrown.expect(UserNameNotFoundException.class);
		this.service.getVehicleDetails("donald");
	}
	
	@Test
	public void getVehicleDetailsShouldReturnMakeAndModel() throws Exception {
		given(this.userRepository.findByUsername("donald"))
			.willReturn(new User("donald", VIN));
		VehicleDetails details = new VehicleDetails("Honda", "Civic");
		given(this.vehicleDetailsService.getVehicleDetails(VIN)).willReturn(details);
		VehicleDetails actual = this.service.getVehicleDetails("donald");
		assertThat(actual).isEqualTo(details);
	}
	

}
