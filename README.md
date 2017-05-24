# SpringBootMicroServices
## Build Microservices with Spring Boot
### Lecture 7.6.1 Measure anything and everything with metrics for Cloud

* Introduction
  * This sample shows how you can use Spring Boot Actuator metrics to talk to a 
    cloud service. In this example we will use datadog.com.

* Prerequisites
  * You need a datadog.com account to run this sample. The offer a free trial. 
    Once you have signed-up, login and select the integrations tab to get the API key. 
    Then add it to src/main/resources/application-secrets.properties:

	datadog.apikey=XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX

* Building and running the sample
  * Use the following commands to build run the application:

    $ mvn clean package
	$ java -jar target/livelessons-operations-cloud-metrics-1.0.0-SNAPSHOT.jar
	
* Explaining the code
  * Live many cloud metrics services datadog.com offers integration with the 
    Dropwizard Metrics library. Spring Boot also supports Dropwizard Metrics so you can use 
    the two together with relative ease.
  
  * The project pom.xml includes dependencies to io.dropwizard.metrics:metrics-core and 
    the org.coursera:dropwizard-metrics-datadog integration library. 
    See OperationsCloudMetricsApplication for the actual datadog configuration.

  * To see the actual request/response HTML you can uncomment the following in 
    application.properties:

	logging.level.org.coursera.metrics.datadog=DEBUG

* Test
  * Start Spring Boot Applicatoin Server
  * http://localhost:8080
  * http://localhost:8080/env --> Check the Spring Boot local server local console box
