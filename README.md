# SpringBootMicroServices
Build Microservices with Spring Boot
## Lecture 6.1: Go beyond HTT REST microservices

* Messaging, Integration & Batch Processing
  * Microservices are fundamentally distributed systems.
  * Microservices don't have to be synchronous REST calls
  * Systems are only as fast as their slowest link
    * Introduce temporal decoupling with store-and-forward systems 
      (messaging) like RabbitMQ
    * Spring Integration elevates programming model to promote event-driven
      architecture
    * Batch data hasn't gone away. Spring Batch is a toolkit for batch processing
  * Common Messaging Concepts in Spring
    * MessageSendingOpertations<T>,
    * MessageReceivingOperation<T>,
    * MessageRequestReplyOperations<T> from Spring Integration
  * MessageListenerContainers support asynchronous receipt of messages ("the Hollywood principle)
    * @*Listener annotations expose POJO-centric MLCs
  * MessageConverters optionally available to control encoding of messages
  * Implementations in various Spring projects supporting JMS, AMQP, Kafka, Redis, Gemfire...
  * JMS
    * Java producers              Message broker               Java consumers
                
                P -->               queue           --->              C             
                
                P -->     			queue           --->              C
    
    * AMQP & RabbitMQ
      * AMQP producers			 Message broker					AMQP consumers
             
             P             --> X -->  queue,queue...            --> C
                                                                --> C
             P             --> X -->  queue,queue...            --> C
                             exchanges
      * AMQP is not the original "Cloud Scale Messaging" ...but close enough!
      * RabbitMQ is Very Fast. (http://bit.ly/1zWNCUv)
