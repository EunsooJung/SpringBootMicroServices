/**
 * HTML Unit test for UserVehicleController
 * Lecture 11.9 Use @WebMvcTest
 */
package com.ej.microservices.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.ej.microservices.service.UserVehicleService;
import com.ej.microservices.service.VehicleDetails;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

/**
 * @author eunsoojung
 *
 */
@RunWith(SpringRunner.class)
@WebMvcTest(UserVehicleController.class)
public class UserVehicleControllerHtmlUnitTest {

	@Autowired
	private WebClient webClient;
	
	@MockBean
	private UserVehicleService userVehicleService;
	
	@Test
	public void getVehicleWhenRequestingTextShouldReturnMakeAndModel() 
		throws Exception {
		given(this.userVehicleService.getVehicleDetails("donald"))
			.willReturn(new VehicleDetails("Honda", "Civic"));
		HtmlPage htmlPage = this.webClient.getPage("/donald/vehicle.html");
		assertThat(htmlPage.getBody().getTextContent()).isEqualTo("Honda Civic");
	}

}
