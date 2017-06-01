# SpringBootMicroServices
## Build Microservices with Spring Boot
### Lecture 8.6 Connect web client to backend services with Zuul

* Edge Service
  * Don't change all the mid-tier microservices each time you add a new client
    * Android, iOS, HTML5, etc.
  * API gateway acts as go-between for mid-tier services and front-end clients
  * New edge service for each client use case
    * Insert security, proxies, adapters, at edge service
  * Zuul makes short work of proxy use cases
  * Reactor makes facade services easy to write, efficiently

* Test example
  * Open Browser --> "localhost:9023/bookmark-service/pwebb/bookmarks"
