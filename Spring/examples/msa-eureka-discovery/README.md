# EUREKA

We will use Eureka to implement our service registry, even though there are other services that provide this like Zookeeper
Service registries are useful becuase they enable client-side load balancing and decouple service providers from consumers without the need for a DNS

  
* only need three files - pom.xml, application.yml/application.properties, and application main class (annotated with @SpringBootApplication)

