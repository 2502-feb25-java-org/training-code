# REST
#### _REpresentational State Transfer_ is a software architectural style that defines a set of constraints to be used for creating web services. 

A RESTful web application exposes information about itself in the form of information about its resources. It also enables the client to take actions on those resources, such as create new resources (ie create a new user) or exchange existing resources (ie change username)

###### Principles of REST
* __resource__ - is any object the API can provide information on. Each resource has a unique identifier. The identifier can be a name or a number
* __representation__ - JSON, XML, or some other transfered data representation of the resource (object and its attributes)
* __messages__ - the use of explicit HTTP methods 

###### Deriving REST 
In order for your API to be RESTful, you must follow a set of constraints: 
* __Client-Server Separation__
	* The _client_ is the person or software using(consuming) the API
	* The _server_ is the person or software producing(exposing) the API
	* This constraint requires that the client and server act independently, on their own, and that the interactions between them is only in the form of requests from the client to the server and responses from the server to the client. 
	* The server simply waits for the requests from the client(s) and does not sending information on its own. 
	* _"Servers and clients may be replaced and developed independently as long as the interface between them is not altered"_
* __Uniform Interface__
	* _"Once a developer becomes familiar with one of your API, they should be able to follow the similar approach for other APIs"_
	* The request to the server has to include a resource identifier
	* The response from the server includes enough information for the client to manipulate the resource 
	* Each request to the API contains all the information that the server needs to perform the request
	* Whenever releavnt, a resource should contain links pointing to relative URIs to getch related information -- _Hypermedia as the engine of application state_ (HATEOAS - yes, weird acronym I know. Let's discuss) 
		* By application we mean web app that the server has deployed 
		* Hypermedia - the hyperlinks, or simply links, that the server can include in the response 
		* Together, we mean that the server can inform the client, in a response, of the ways to change the state of the web application. 
* __Stateless__
	* This means that the server does not keep track of prior requests
	* Sessions should be stored entirely by the client, meaning that if the server receives two separate requests from the same client, it should not remember anything about the first request by the time the second one comes through. Because of this, _every request from the client should carry all the information necessary for an action to be performed by the server_
	* The rationale for this is that as the number of clients grows, the server will not have to keep track of all the clients it is talking to which would take a lot of time and space. This ensures that our system scales well 
* __Cacheable__
	* _Well-managed caching partially or completely eliminates some client-server interactions, further improving scalability and performance_
	* This means that the data that the server sends contains information about whether or not the it is cacheable, and if it is, it should contain a sort of version number to make caching possible
* __Layered system__
	* REST allows you to use a layered system architecture where you deploy the APIs on server A, and store data in server B, and authenticate requests in Server C, for example. A client cannot ordinarily tell whether it is connected directly to the end server, or to an intermediary along the way. 
* __Code-on-demand__ 
	* This constraint is optional (an API can be RESTful even without providing code on demand)
	* The client can request code from the server, and then the response from the server will contain some code, usually in the form of a script, when the response is in HTML format. The client can then execute that code
	


###### Sources and Important Readings 
* [Representational State Transfer(REST) by Fielding](https://www.ics.uci.edu/~fielding/pubs/dissertation/rest_arch_style.htm)
* [What is REST - A Simple Explanation for Beginners](https://medium.com/extend/what-is-rest-a-simple-explanation-for-beginners-part-1-introduction-b4a072f8740f)
* [REST API Tutorial](restfulapi.net/)
* [A Quick Understanding of REST](https://scotch.io/bar-talk/a-quick-understanding-of-rest)