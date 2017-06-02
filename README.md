# SpringBootMicroServices
## Build Microservices with Spring Boot
### Lecture 10.3 Understand x509
 
* SSL and TLS
  * SSL/TLS can be used to identity the client to the server,
    through mutual authentication
  * Browser/client must send their certivicate, as well
  
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http.authorizeRequests()
    		.anyRequest().authenticated()
    		.and()
    		.x509();
    }
    
    is very secure environments.

* SSL/TLS and x509 Mutual Authentication
  * SSL/TLS is used routinely to verify the identity of servers
  * It's easy enough to setup SSL/TLS on your web server
  * Normally, the client confirm the server, but the server rarely
    requires the client to transmit a certificate
    * This isn't very scalable approach on the open-web, but
      might be all you need in mid-tier services
