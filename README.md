# SpringBootMicroServices
## Build Microservices with Spring Boot
### Lecture 10.2 Understand HTTP Basic

* Provider Manager, AuthenticationProvider

* Usernames and Passwords
  * If you can trust the client to keep a secret like a password,
    then you can send the password using:
    * HTTP Basic - passwords are sent in plaintext!
    * HTTP Digest - hashed passwords, but still plaintext.
  * SSL/TLS encryption helps prevent man-in-the-middle attacks.

* Implements Basic HTTP example
  * pom.xml
    - jpa, security, web, h2, test

* To Test
  * Start Server
  * Open web browser --> localhost:8080/hi
