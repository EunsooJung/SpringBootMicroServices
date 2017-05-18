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

* Lecture 5.8: Use Differential Synchronization and JSON PATCH

  * JSON PATCH with Spring Sync
    * Differential Synchronization lets two nodes reconcile view of data
    * Spring Sync supports differential synchronization through a 
      DiffSyncController & JSON PATCH
    * When applying DS, each node maintains two copies of a resource:
      * The local node's own working copy that it may change.
      * A shadow copy which is the local node's understanding of what a remote
        node's working copy looks like.
      * Upon receiving a patch, a node must apply the patch to the shadow that it
        keeps for the node that sent the patch and to its own local copy (which may
        have had changes itself)
    * As it handles PATCH requests, DiffSyncController will apply one cycle of the 
      DS flow:
      * It will apply the patch to the server copy of the resource and to the shadow
        copy for the client who sent the PATCH.
      * It will create a new patch by comparing its local resource with the shadow copy.
      * It will replace the shadow copy with the local copy of the resource.
      * It will send the new patch on the response to the client.
