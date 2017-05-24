# SpringBootMicroServices
## Build Microservices with Spring Boot
### Lecture 7.4 Monitoring Microservices

* Too may services to monitor manually
* Resilient design (circuit breakers) means you need to monitor all services
* What indicates a healthy service
  * Network connection
  * Database connection
  * Disk space
* Several monitors built into Spring Boot
* Write your own
  
  @Component
  public class ExampleHealthIndicator extends AbstractHealthIndicator {
  
  		@Override
  		protected void doHealthCheck(Builder builder) throws Exception {
  			builder.status(test() ? Status.UP : Status.DOWN);
  		}
  }
  
* Once you have a health endpoint you can use could monitoring services:
  * Pingdom
  * Uptime Robot
  * Pager Duty
  * ...
  
* Introduction
  * This sample provides an introduction to the monitor support built into Spring Boot.

* Running this example
  * Check the health of the application by hitting the http://localhost:8080/health endpoint.

* Explain the Code
  * This sample demonstrates a custom HealthIndicator and HealthAgregator. 
    It also shows how you can remap status code responses.
    
* Exposing full health information
  * By default Spring Boot doesn’t expose all the information used tell if an application is 
    healthy, you just get a single status response. 
    This application has endpoints.health.sensitive set to false to show all information 
    in the JSON.

* HealthIndicator
  * You can easily write your own HealthIndicator to extend the standard ones provided by 
    Spring Boot. The ExampleHealthIndicator in this project randomly returns up or 
    outOfService. Refresh your browser several times on the /info endpoint and you should see the 
    health toggle.

* HealthAggregator
  * The HealthAggregator interface is responsible for combining all health results into a 
  single response. In this project we have a ExampleHealthAgregator which re-orders which 
  status has the highest priority.

* HTTP status mapping
  * By default Spring Boot will map OK status to HTTP 200 and DOWN or OUT_OF_SERVICE to HTTP 503. 
    You can customize this in the application properties. This sample uses:

    endpoints.health.mapping.OUT_OF_SERVICE=i-am-a-teapot
  
  * To remap OUT_OF_SERVICE to HTTP 418 (an IETF April Fools' joke in RFC 2324)
