# SpringBootMicroServices
## Build Microservices with Spring Boot

### Lecture 6.2 Go Understand "Enterprise Application Integration Patterns" with RabbitMQ

* Types of Application Integration 
  (Book: Enterprise Integration patterns by Gregor Hohpe, Bobby Woolf) 
  * File transfer
  * Shared database
  * RPC
  * Messaging

* Spring Integration
  * Embedded message bus
  * Application integration framework based on Spring

* The Integration Bus
      n(n-2)
      ------
        2

    A <-----> B
    ^ \     / ^
    |   \  /  |
    v   / \   v
    C <-----> D

* Spring Integration Components
  * transformers: convert payloads and modify headers
  * filter: discards messages based on tests
  * router: determines next channel based on messages and conditions
  * splitter: generates multiple messages from one
  * aggregator: assembles a single message from multiple message
  * service activator: delegates processing to a backend service calls

* Install RabbbitMQ on Mac Guide
  * https://www.youtube.com/watch?v=8mFsh1cwlsA 
  

