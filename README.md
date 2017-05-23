# SpringBootMicroServices
## Section 7: Create Operation-Friendly Microservices
### Learning Objectives

* 7.1 Understand the implications of agile methodologies on operation
* 7.2 Gain insight via logging
* 7.3 Introduce the Spring Boot Actuator
* 7.4 Monitor microservices
* 7.5 Diagnose errors
* 7.6 Measure anything and everything with metrics
* 7.7 Extend the Spring Boot Actuator

### Lecture 7.1 Understand the implications of agile methodologies on operation

* The Impact of Agile on Operations
  * Being agile implies production ready shippable code
  * Continuous delivery and continuous deployment are common for microservices
  * You built it, you run it.
  * Lots of different services mean lots of different things to go wrong

### Lecture 7.2 Gain insight via logging

* Logging
  * Still the most common way to diagnose problems in production.
  * Should be easy, I'll just use a logging library...
    * SLF4J, Commons Logging, JBoss Logging, Java Util Logging, Log4J, Tomcat JULI, Logback
  * Is my log easy to read and parse ?
  * Where should I write logs ? 
