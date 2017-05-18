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

* Lecture 5.7: Versioning REST API
  * Versioning REST API
    * Build a version into your API
    * API versions can be dealt with one of two way:
      * Through API URIs: https://api.foo.com/v1
      * Through media types: application/vnd.company.urapp-v3+json
