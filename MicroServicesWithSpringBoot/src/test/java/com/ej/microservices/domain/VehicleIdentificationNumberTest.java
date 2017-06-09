/*
 * Lecture 11.7 Use @DataJpaTest
 */

package com.ej.microservices.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

//@RunWith(SpringRunner.class)
//@DataJpaTest
public class VehicleIdentificationNumberTest {
	
	private static final String SV = "01234567890123456"; // SV: Sample VIN
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void createWhenVinIsNullShouldThrowException() throws Exception {
		this.thrown.expect(IllegalArgumentException.class);
		this.thrown.expectMessage("VIN must not be null");
		new VehicleIdentificationNumber(null);
	}

	@Test
	public void createWhenVinMoreThan17CharsShouldThrowException() throws Exception {
		this.thrown.expect(IllegalArgumentException.class);
		this.thrown.expectMessage("VIN must be exactly 17 characters");
		new VehicleIdentificationNumber("012345678901234567");
	}

	@Test
	public void createWhenVinIsLessThan17CharsShouldThrowException() throws Exception {
		this.thrown.expect(IllegalArgumentException.class);
		this.thrown.expectMessage("VIN must be exactly 17 characters");
		new VehicleIdentificationNumber("0123456789012345");
	}

	@Test
	public void toStringShouldReturnVin() throws Exception {
		VehicleIdentificationNumber vin = new VehicleIdentificationNumber(SV);
		assertThat(vin.toString()).isEqualTo(SV);
	}
	
	@Test
	public void equalsAndHashCodeShouldBeBasedOnVin() throws Exception {
		VehicleIdentificationNumber vin1 = new VehicleIdentificationNumber(SV);
		VehicleIdentificationNumber vin2 = new VehicleIdentificationNumber(SV);
		VehicleIdentificationNumber vin3 = new VehicleIdentificationNumber(
				"00000000000000000");
		assertThat(vin1.hashCode()).isEqualTo(vin2.hashCode());
		assertThat(vin1).isEqualTo(vin1).isEqualTo(vin2).isNotEqualTo(vin3);
	}

}
