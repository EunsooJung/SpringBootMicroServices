/**
 * 
 */
package com.ej.microservices;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author eunsoojung
 *
 */
@RestController
public class CloudMonitoringExampleController {
	
	private final CloudHealthExampleindicator cloudIndicator;
	
	public CloudMonitoringExampleController(CloudHealthExampleindicator cloudIndicator) {
		this.cloudIndicator = cloudIndicator;
	}
	
	@RequestMapping("/")
	public String hello() {
		return "Hello Cloud World!";
	}
	
	@RequestMapping("/up")
	public String up() {
		this.cloudIndicator.setup(true);
		return "now up";
	}
	
	@RequestMapping("/down")
	public String down() {
		this.cloudIndicator.setup(false);
		return "now down";
	}

}
