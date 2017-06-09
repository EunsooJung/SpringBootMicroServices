/**
 * Lecture 11.9 Use @WebMvcTest
 */
package com.ej.microservices.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.ej.microservices.service.UserVehicleService;
import com.ej.microservices.service.VehicleDetails;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;;
/**
 * @author eunsoojung
 * {@code @SpringBootTest} based tests for {@link UserVehicleController}.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
public class UserVehicleControllerApplicationTest {

	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private UserVehicleService userVehicleService;
	
	@Test
	public void getVehicleWhenRequestingTextShouldReturnMakeAndModel()
		throws Exception {
		given(this.userVehicleService.getVehicleDetails("donald"))
			.willReturn(new VehicleDetails("Honda", "Civic"));
		this.mvc.perform(get("/donald/vehicle").accept(MediaType.TEXT_PLAIN))
			.andExpect(status().isOk())
			.andExpect(content().string("Honda Civic"));
	}
	

}
