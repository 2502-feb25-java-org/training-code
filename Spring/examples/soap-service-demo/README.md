# SOAP Service Application 

This application will cover what is necessary to create a basic SOAP service. 

### About [SOAP](https://www.guru99.com/soap-simple-object-access-protocol.html)
* Simple Object Access Protocol
* Defines an XML based structure for passing information, such as messages, between applications
* Usually not used between client and server, but in B2B(business to business)
* Platform independent
* Not tied to any particular transport - can use FTP, SMTP, etc - but usually leverages HTTP
* When using HTTP, request methods can be sent as GET or POST requests 
* SOAP is a contract based language - it relies on the [WSDL](https://www.guru99.com/wsdl-web-services-description-language.html)
* We leverage [JAX-B](https://docs.oracle.com/javase/tutorial/jaxb/intro/index.html), [JAX-WS](https://www.baeldung.com/jax-ws), and [Apache CXF](https://cxf.apache.org/docs/cxf-architecture.html) to create SOAP services 

### Recreating This Application 
* Create a simple maven project packaged as a .war 
* Copy the following depdencies in your pom:
```
     <dependency>
            <groupId>org.apache.cxf</groupId>
            <artifactId>cxf-rt-frontend-jaxws</artifactId>
            <version>3.1.6</version>
        </dependency>
        <dependency>
            <groupId>org.apache.cxf</groupId>
            <artifactId>cxf-rt-transports-http</artifactId>
            <version>3.1.6</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-web</artifactId>
            <version>4.1.9.RELEASE</version>
        </dependency>
```
* Create a Deployment Descriptor and copy the following contents:
