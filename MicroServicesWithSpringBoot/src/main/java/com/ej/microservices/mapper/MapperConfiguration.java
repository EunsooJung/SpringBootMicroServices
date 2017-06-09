/**
 * 
 */
package com.ej.microservices.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author eunsoojung
 *
 */
@Configuration
public class MapperConfiguration {
	
	private ModelMapper modelMapper;

	/**
	 * @param modelMapper
	 */
	public MapperConfiguration(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}
	
	@Bean
	public OrderDto orderDto() {
		Name name = new Name();
		name.setFirstName("Danger");
		name.setLastName("Mouse");
		
		Customer customer = new Customer();
		customer.setName(name);
		
		Address billingAddress = new Address();
		billingAddress.setCity("London");
		billingAddress.setStreet("221c Baker Street");
		
		Order order = new Order();
		order.setCustomer(customer);
		order.setBillingAddress(billingAddress);
		
		return this.modelMapper.map(order, OrderDto.class);
	}
	
	@Bean
	public CommandLineRunner print(OrderDto dto) {
		return (args) -> System.err.println(dto);
	}
	

}
