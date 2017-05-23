# SpringBootMicroServices
## Section 7: Create Operation-Friendly Microservices
### Lecture 7.2 Gain insight via logging

* Introduction
  * Provides an overview of default logging with Spring Boot.

* Understanding the code
  * The LoggerExample @Component shows the many different logging solutions that exist and 
    how they all redirect to the same output. You won’t usually mix logging libraries in 
    your own code, but you may well depend on many different third-party libraries which 
    have each chosen a different way to log.

    Notice consistent format of the log, the color output and the additional whitespace 
    that is included around stacktraces.

    You can experiment with different logging levels by adding logging.
    level properties to the application.properties file, eg:
    
    logging.level.org.springframework.boot: DEBUG

    If you want to write the log to a file uncomment the following line from 
    application.properties:

    logging.file: myapp.log

* Logging
  * Still the most common way to diagnose problems in production.
  * Should be easy, I'll just use a logging library...
    * SLF4J, Commons Logging, JBoss Logging, Java Util Logging, Log4J, Tomcat JULI, Logback
  * Is my log easy to read and parse ?
  * Where should I write logs ? 
