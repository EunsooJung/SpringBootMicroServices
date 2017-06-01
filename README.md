# SpringBootMicroServices
## Build Microservices with Spring Boot
### Section 1: Introduce Spring Boot
 
* 1.1 Introduce Spring Boot
  * What is Spring Boot?
    - An opinionated, production-ready way to consume all of Spring
    - Sesnible defaults and automatic configuration
    - Embedded HTTP Server support
    - Spring framework + Tomcat or Jetty/Underlow (xml and @Configuration)
 
 * How Does it Help Microservices?
  * You are going to write more than one microservice
  * That means your going to do this a lot...
    - Declare dependencies
    - Setup monitoring
    - Configure Spring
    - Configure Logging
    - Load properties
    - Add Security
    - Talk to a database
    - Add metrics
* 1.2 Write Groovy-based Spring CLI applications
  * Open your Command prompt
  * input brew tap pivotal/tap
  * brew install springboot
  * Grooty script
    * subl app.groovy
    
    @RestController
    public class Application {
    	
    	@RequestMapping("/")
    	public String hello() {
    	return "Hello World!"
    }
  * Go to command prompt
  * spring run app.groovy
  * Open Web Browser
    * localhost:8080 --> Hello World!
