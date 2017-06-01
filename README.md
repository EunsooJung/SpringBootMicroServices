# SpringBootMicroServices
## Build Microservices with Spring Boot
### Lecture 8.2 Discover and register services with Eureka and Consul

* So Everuthing's a Service...Now What ?
  * As you introduce different services, you introduce fragility in the
    connections between them
  * SLA's is only as good as weakest in chain
  * Build in fault-tolerance from the beggining
  * Smart Services, Dump Pipes (Netflix)
  * Standing on the Shoulders of Spring & Netflix

* Robust Service-to-Service Invocations
  * Service registration and discovery with Consul or Eureka
  * Circuit breakers or Bulkheads with Hystrix and the Hystrix Dashboard
  * Declarative REST service clients with Feign
  * Client-side load balancing with Ribbon
    * integration with RestTemplate, Feign, Zuul

* Service Registration & Discovery
  * A Service Registry is like a service phone-book
  * Spring Cloud supports (at least) Consul and Netflix's Eureka
  * Ask questions about state of system
    * "Is the 'customer-service' available? If so, on which host/port?"
  * Automatic registration of services
  * Use DiscoveryClient for programmatic client access
