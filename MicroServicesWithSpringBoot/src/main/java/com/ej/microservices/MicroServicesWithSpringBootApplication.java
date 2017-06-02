/*
 * ref.: https://github.com/livelessons-spring/building-microservices/blob/master/livelessons-data/livelessons-data-jdbc/src/main/java/demo/DataJdbcApplication.java
 */

package com.ej.microservices;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@SpringBootApplication
public class MicroServicesWithSpringBootApplication extends WebMvcConfigurerAdapter{
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("index");
	}

	public static void main(String[] args) {
		SpringApplication.run(MicroServicesWithSpringBootApplication.class, args);
	}
	
}