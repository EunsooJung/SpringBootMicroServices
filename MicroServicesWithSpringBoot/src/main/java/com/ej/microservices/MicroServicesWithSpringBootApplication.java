/*
 * Section 8: Choreographing Microservices
 *   Lecture 8.4.1 Prevent failure cascades using Hystrix Dashboard Service
 */

package com.ej.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@EnableHystrixDashboard
@SpringBootApplication
public class MicroServicesWithSpringBootApplication {
	
	@RequestMapping("/")
	public String home() {
		return "forward:/hystrix/index.html";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(MicroServicesWithSpringBootApplication.class, args);
	}
	
}