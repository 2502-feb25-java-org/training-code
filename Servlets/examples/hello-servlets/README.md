# Servlets!

This application will cover the basics of Java Servlets, which allow us to process web requests and produce responses 

#### A few facts about Servlets:
* javax.servlet package 
* The servlet hierarchy is as follows: `Servlet` (interface) -> `GenericServlet` (abstract class) -> `HttpServlet` (abstract class
* The servlet lifecycle is init() -> service() -> destroy

#### To recreate this app: 
* Create a new Maven project
	* simple project (skip archetype selection)
	* package: war
	* copy the POM in this app (the dependencies and the package at Java 1.8)
	* Right click on project --> Java EE tools --> Generate deployment descriptor stub
		* This will create your `web.xml` which can be found in src > main > webapp > WEB-INF 
	* Create servlet classes 
		* create class that extends either GenericServlet or HttpServlet
		* follow guidelines in this application's web.xml

#### Topics Covered:
* How to create a servlet
* servlet lifecycle
* GenericServlet vs HttpServlet
* contents of the web.xml
* ServletConfig
* ServletContext
* @WebServlet
* HttpVerbs 
* Dealing with form data in servlets
* AJAX review
* use of jQuery to select/manipulate DOM elements 
* redirecting and forwarding 
* session management 
* Servlet filters - used for monitoring request and response from client to the servlet, or to modify the request and response, or to audit and log.
* Servlet listeners - used for lisenting to events in a web containers, such as when you create a session, or place an attribute in an session or if you passivate and activate in another container, to subscribe to these events you can configure listener in web.xml, for example HttpSessionListener

