# SpringBootMicroServices
## Build Microservices with Spring Boot

* Section 5: Giving your Microservice a REST
  * Lecture 5.6: Handle errors in REST
 
* Errors
  * Extreme programming and test-driven development embrace this truth
  * Errors introduce transparency
  * Status codes map to errors
  * Pick a meaningful subset fo the 70+ status codes:
    * 200 - OK
    * 201 - Created
    * 304 - Created - Not Modified
    * 400 - Bad Request
    * 401 - Unauthorized
    * 403 - Forbidden
    * 404 - Not Found
    * 500 - Internal Server Error
  * Send meaningful errors along with status codes
    * application / vnd.error + json
    * application / vnd.error + xml
