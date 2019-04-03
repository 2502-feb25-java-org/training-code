#Spring Data


* Spring data is our last, or most abstracted, data persistence tool for our stack. 
we began with JDBC, which is a low level connection with a DB from Java, where we simply write SQL queries and execute them over a basic connection on our RDB
Then, we learned Hibernate - our first ORM tool. Hibernate abstracts JDBC and introduces object oriented and dialect agnostic Data persistence. 

After Hibernation came Spring! 

We started with Spring ORM, which is Spring's module to abstract transaction management from our JPA tool (Hibernate is the only one anyone really uses). But we still have to write methods, and still have direct managemnet over our sessions 

Then, comes the final boss, if you will, of persistence which is Spring Data. Where we simply extend springdatajpa interfaces and inherit their persistence functionality... more on this to come





Spring Data's mission is to provide a familiar and consistent, Spring-based programming model for data access while still retaining the special traits of the underlying data store.

It makes it easy to use data access technologies, relational and non-relational databases, map-reduce frameworks, and cloud-based data services. This is an umbrella project which contains many subprojects that are specific to a given database. The projects are developed by working together with many of the companies and developers that are behind these exciting technologies.

Features
Powerful repository and custom object-mapping abstractions

Dynamic query derivation from repository method names

Implementation domain base classes providing basic properties

Support for transparent auditing (created, last changed)

Possibility to integrate custom repository code

Easy Spring integration via JavaConfig and custom XML namespaces

Advanced integration with Spring MVC controllers

Experimental support for cross-store persistence