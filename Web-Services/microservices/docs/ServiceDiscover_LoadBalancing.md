#Service Discovery
###The Service Registry
*Database of service instances
*Provides management API/query API
*Where service instances are registered/deregistered
*Netflix Eureka!
<br/>

##Service Discovery Types
*Client-Side Discovery
*Server-Side Discovery
<br/>

###Client-Side Discovery
*Client query the service registry
*Select an available instance
*Make a request
<br/>

###Server-Side Discovery
*Clients make a request via a load balancer(router)
*LB queries the service registry
*Then forwards the request to an available instance
<br/>

##Service Registration
*Self-Registration Pattern
*Third-Party Registration Pattern
<br/>

#Load Balancing
###What is Load Balancing?
 	*Traffic Cop
	*Maximizes speed and capacity
	*Delivers Server Demand
Refers to efficiently distributing incoming network traffic across a group of backend servers, also known as a server farm or server pool.
<br/>

###Load Balancing Algorithms
 	*Round Robin
	*Least Connections
	*IP Hash
<br/>

###Eureka
	*Eureka is a service discovery pattern implementation
	*Microservice is registered in the server
	*Client microservice looks up the server to get dependent microservice
Eureka is a REST (Representational State Transfer) based service that is primarily used in the AWS cloud for locating services for the purpose of load balancing and failover of middle-tier servers.
<br/>


###Netflix and Eureka
	Aiding Netflix Asgard
		Fast Rollback
		Avoid Propagation
	Traffic Maintenance
For aiding Netflix Asgard - an open source service which makes cloud deployments easier, in
Fast rollback of versions in case of problems avoiding the re-launch of 100's of instances which could take a long time.
In rolling pushes, for avoiding propagation of a new version to all instances in case of problems.
For our cassandra deployments to take instances out of traffic for maintenance
<br/>



