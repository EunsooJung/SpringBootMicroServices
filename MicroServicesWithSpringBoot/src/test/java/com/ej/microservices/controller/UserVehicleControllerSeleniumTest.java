/*
 * Selenium Web Driver Test
 * Lecture 11.9 Use @WebMvcTest
 */

package com.ej.microservices.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.ej.microservices.service.UserVehicleService;
import com.ej.microservices.service.VehicleDetails;

@RunWith(SpringRunner.class)
@WebMvcTest(UserVehicleController.class)
public class UserVehicleControllerSeleniumTest {

	@Autowired
	private WebDriver webDriver;
	
	@MockBean
	private UserVehicleService userVehicleService;
	
	@Test
	public void getVehicleWhenRequestingTextShouldReturnMakeAndModel()
		throws Exception {
		given(this.userVehicleService.getVehicleDetails("donald"))
			.willReturn(new VehicleDetails("Honda", "Civic"));
		this.webDriver.get("/donald/vehicle.html");
		WebElement element = this.webDriver.findElement(By.tagName("h1"));
		assertThat(element.getText()).isEqualTo("Honda Civic");
	}

}
