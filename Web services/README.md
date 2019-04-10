# Learning Web Services

### This week's objectives
* Understanding [Service Oriented Architecture](http://www.opengroup.org/soa/source-book/soa/p1.htm)
* Learn the basics of web Services
	* Read [The Twelve Factor App](https://12factor.net/)
* Understanding SOAP
	* What defines a service as a SOAP service?
	* What can tools can we leverage to create a SOAP service?
	* What is the WSDL? What are some important tags in the WSDL?
	* What are some important tags in a SOAP message?
	* How do we create a SOAP service?
	* How do we consume a SOAP service?
* Understanding REST
	* Read [Deriving REST](https://www.ics.uci.edu/~fielding/pubs/dissertation/rest_arch_style.htm)
	* Create a RESTful web service with Spring MVC
	* Consume the service with Angular
	* Consume the service from another Java application using Rest Template
		* [Tutorial](https://www.journaldev.com/17096/spring-resttemplate-example)
* What are the differences between SOAP and REST?
* What is a monolithic app?
* What are microservices?
	* Read [Fowler article](https://martinfowler.com/articles/microservices.html)
	* Understand Netflix microservices technology and why it came to be
		* Watch [A Netflix Guide to Microservices](https://www.youtube.com/watch?v=CZ3wIuvmHeM)
		* Follow some [blogs](https://medium.com/netflix-techblog/tagged/microservices)!
	* Build a basic MSA with two services registered with [Eureka](https://github.com/Netflix/eureka/wiki/Eureka-at-a-glance) and accessible through [Zuul](https://github.com/Netflix/zuul/wiki)
		* check the repo for guidance
		* Understand the basic annotations necessary for these applications 
	* Add a [cloud configuration](https://dzone.com/articles/microservices-and-spring-cloud-config-server) server to your MSA 
	* Understandind the purpose of [messaging queues](https://docs.oracle.com/cd/E19435-01/819-0069/intro.html)
		* [Kafka vs Rabbit MQ](https://dzone.com/articles/exploring-message-brokers)
	* [Circuit Breakers](https://microservices.io/patterns/reliability/circuit-breaker.html)
	* Learn [Docker](https://www.guru99.com/docker-tutorial.html)! 