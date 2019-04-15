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
```
<context-param>
	<param-name>contextConfigLocation</param-name>
	<param-value>WEB-INF/beans.xml</param-value>
</context-param>

<listener>
	<listener-class>
		org.springframework.web.context.ContextLoaderListener
	</listener-class>
</listener>

	<servlet>
		<servlet-name>CXFServlet</servlet-name>
		<servlet-class>org.apache.cxf.transport.servlet.CXFServlet</servlet-class>
	</servlet>
	<servlet-mapping>
		<servlet-name>CXFServlet</servlet-name>
		<url-pattern>/*</url-pattern>
	</servlet-mapping>
```
* Create the Interface of the service you'd like to expose. Annotate it with `@WebService`
* Create the implementing class of the interface, annotate it with `@WebService(endpointInterface="[interface full name]")`
* Create a Spring Bean Configuration File in your WEB-INF folder, select the beans, context, and jaxws namespaces and add the following:
```
<import resource="classpath:META-INF/cxf/cxf.xml" />

<!-- indicate our service endpoint interface  -->

<jaxws:endpoint
	implementor="[implementing class]"
	address="/[endpoint]"
/>
```
* deploy to server and access at localhost:[port]/[context root]

