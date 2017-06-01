# SpringBootMicroServices
## Build Microservices with Spring Boot
### Lecture 8.3 Route on the client with Ribbon (Client-Side load balancing)

* Client-Side Load Balancing
  * Load-balance traffic in mid-tier services along with service registry
    * Rely on DNS and cloud load balancings (like Cloud Foundary's router, 
      or Amazon's ELB service) at edge services
  * Netflix's Robbon provides many software load-balancers out the box
  * You probably won't use it directly as it's integrated with Freign,
    Spring's RestTemplate, and Zuul automatically in Spring Cloud

* The Smart REST Client
  * Spring Could's RestTemplate is Ribbon-aware
  * Feign makes short work of building REST services

* Implements using Ribbon and Eureka
  * pom.xml
