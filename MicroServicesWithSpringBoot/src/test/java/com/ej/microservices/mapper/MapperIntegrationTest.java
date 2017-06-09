package com.ej.microservices.mapper;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MapperIntegrationTest {

	@Autowired
	private OrderDto dto;
	
	@Test
	public void modelMapperRuns() throws Exception {
		assertThat(this.dto.toString())
					.isEqualTo("Danger Mouse - 221c Baker Street, REDACTED");
	}
	

}
