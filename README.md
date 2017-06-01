# SpringBootMicroServices
## Build Microservices with Spring Boot
### Lecture 8.5 Isolate failures using circuit breakers

* Circuit Breaker (noun: an automatic device for stopping the flow of current in an 
                         electric circuit  as a safety measure) pattern
  * Isolate service failure with a basic state machine around (by definition risky)
    service-to-service communication
  * Also called a bulk head
  * Hystrix is easy to plug in and easy to monitor
