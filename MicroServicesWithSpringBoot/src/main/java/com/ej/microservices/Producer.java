/**
 * 
 */
package com.ej.microservices;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author eunsoojung
 *
 */
@Component
public class Producer implements CommandLineRunner {
	
	private final RabbitMessagingTemplate messagingTemplate;
	
	public Producer(RabbitMessagingTemplate messageTemplate) {
		this.messagingTemplate = messageTemplate;
	}

	@Override
	public void run(String... args) throws Exception {
		Notification notification = new Notification(UUID.randomUUID().toString(),
				"Hello, Michael!", new Date());
		
		Map<String, Object> headers = new HashMap<>();
		headers.put("notification-id", notification.getId());
		
		this.messagingTemplate.convertAndSend(
				MicroServicesWithSpringBootApplication.NOTIFICATIONS, notification, headers,
				message -> {
					System.out.println("sending " + message.getPayload().toString());
					return message;
				});
	}
	
	
	
}
