/*
 * Lecture 11.9 Use @WebMvcTest
 */

package com.ej.microservices.controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.ej.microservices.domain.VehicleIdentificationNumber;
import com.ej.microservices.exception.UserNameNotFoundException;
import com.ej.microservices.exception.VehicleIdentificationNumberNotFoundException;
import com.ej.microservices.service.UserVehicleService;
import com.ej.microservices.service.VehicleDetails;

@RunWith(SpringRunner.class)
@WebMvcTest(UserVehicleController.class)
public class UserVehicleControllerTest {

	private static final VehicleIdentificationNumber VIN = new VehicleIdentificationNumber(
			"01234567890123456");
	
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private UserVehicleService userVehicleService;
	
	@Test
	public void getVehicleWhenRequestingTextSouldReturnMakeAndModel() 
		throws Exception {
			given(this.userVehicleService.getVehicleDetails("donald"))
				.willReturn(new VehicleDetails("Honda", "Civic"));
			this.mvc.perform(get("/donald/vehicle").accept(MediaType.TEXT_PLAIN))
				.andExpect(status().isOk())
				.andExpect(content().string("Honda Civic"));
	}
	
	@Test
	public void getVehicleWhenRequestingJsonShouldReturnMakeAndModel() throws Exception {
		given(this.userVehicleService.getVehicleDetails("donald"))
				.willReturn(new VehicleDetails("Honda", "Civic"));
		this.mvc.perform(get("/donald/vehicle").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().json("{'make':'Honda','model':'Civic'}"));
	}
	
	@Test
	public void getVehicleWhenRequestingHtmlSholdReturnMakeAndModel()
		throws Exception {
			given(this.userVehicleService.getVehicleDetails("donald"))
				.willReturn(new VehicleDetails("Honda","Civic"));
			this.mvc.perform(get("/donald/vehicle.html").accept(MediaType.TEXT_HTML))
				.andExpect(status().isOk())
				.andExpect(content().string(containsString("<h1>Honda Civic</h1>")));
	}
	
	@Test
	public void getVehicleWhenUserNotFoundShouldReturnNotFound() 
		throws Exception {
			given(this.userVehicleService.getVehicleDetails("donald"))
				.willThrow(new UserNameNotFoundException("donald"));
			this.mvc.perform(
					get("/donald/vehicle")).andExpect(status().isNotFound());
	}
	
	@Test
	public void getVehicleWhenVinNotFoundShouldReturnNotFound() throws Exception {
		given(this.userVehicleService.getVehicleDetails("donald"))
		.willThrow(new VehicleIdentificationNumberNotFoundException(VIN));
		this.mvc.perform(
				get("/donald/vehicle")).andExpect(status().isNotFound());
	}

}
