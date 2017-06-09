/**
 * 
 */
package com.ej.microservices.service;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.client.HttpServerErrorException;

import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import com.github.tomakehurst.wiremock.junit.WireMockRule;


/**
 * @author eunsoojung
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RemoteVehicleDetailsServiceTest {
	
	private static final String VIN = "01234567890123456";

	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Rule
	public WireMockRule wireMock = new WireMockRule(
			WireMockConfiguration.options().dynamicPort());
	
	@Autowired
	private RemoteVehicleDetailsServiceProperties properties;
	
	@Autowired
	private RemoteVehicleDetailsService service;
	
	@Before
	public void setup() {
		this.properties.setRootUrl("http://localhost:" + 
					this.wireMock.port() + '/');
	}
	
	@Test
	public void getVehicleDetailsWhenVinIsNullShouldThrowException() 
		throws Exception {
		this.thrown.expect(IllegalArgumentException.class);
		this.thrown.expectMessage("VIN must not be null!");
		this.service.getVehicleDetails(null);
	}
	
	@Test
	public void getVehicleDetailsWhenResultIsSuccessShouldReturnDetails() 
		throws Exception {
		this.wireMock.stubFor(
				get(urlEqualTo("/vehicle/" + VIN + "/details"))
				.willReturn(aResponse().withStatus(200)
						.withHeader(HttpHeaders.CONTENT_TYPE,
								MediaType.APPLICATION_JSON_VALUE)
						.withBody(getClassPathResource("vehicledetails.json"))));
		VehicleDetails details = this.service
				.getVehicleDetails(new VehicleIdentificationNumber(VIN));
		assertThat(details.getMake()).isEqualTo("Honda");
		assertThat(details.getModel()).isEqualTo("Civic");
	}
	
	@Test
	public void getVehicleDetailsWhenResultIsNotFoundShouldThrownException() 
		throws Exception {
		this.wireMock.stubFor(
				get(urlEqualTo("/vehicle/" + VIN + "/details"))
				.willReturn(aResponse().withStatus(404)));
		this.thrown.expect(VehicleIdentificationNumberNotFoundException.class);
		this.service.getVehicleDetails(new VehicleIdentificationNumber(VIN));
	}
	
	@Test
	public void getVehicleDetailsWhenResultIsServerErrorShouldThrownException() 
		throws Exception {
		this.wireMock.stubFor(
				get(urlEqualTo("/vehicle/" + VIN + "/details"))
				.willReturn(aResponse().withStatus(500)));
		this.thrown.expect(HttpServerErrorException.class);
		this.service.getVehicleDetails(new VehicleIdentificationNumber(VIN));
	}

	private byte[] getClassPathResource(String path) throws IOException{
		ClassPathResource resource = new ClassPathResource(path, getClass());
		return FileCopyUtils.copyToByteArray(resource.getInputStream());
	}

}
