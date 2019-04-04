# SPRING MVC

### Model-View-Controller Pattern
* Model = our data
* View = what the user sees(either a template with interpolated data generated server-side with technologies like JSPs or, in our case, formatted model data)
* Controller = class that collects the data for the model
    * main abstraction of Spring MVC implementation 
    * DispatcherServlet (Front Controller Servlet of the architecture) consults the Handler Mapping to send requests to appropriate controller methods

### Spring MVC Annotations 
* `@Controller` - Stereotypes a component as a Spring MVC controller. To be applied to classes
* `@RestController` - Same functionality as `@Controller` but methods are assumed to return model data instead of a view, so the methods do not need to be annotated with `@ResponseBody` as they would otherwise to indicate that
* `@RequestMapping` - Maps a URL pattern, HTTP method, request/response content type, etc to a method or controller. 
* `@RequestParam` - To be applied in a parameter to bind a request parameter to the method parameter


### To recreate this app:
* Create a new maven project packaged as a .war
* copy the contents of this pom.xml (need the basic spring core modules, spring mvc, and jackson object mapper, and commons logging -- used for spring logs )
* Create your web.xml (right click on project -> Java EE tools -> generate deployment descriptor stub)
* Create your beans.xml INSIDE OF WEB.INF FOLDER. (spring beans configuration file if you have a spring plugin, which you should)
	* inside of beans.xml, configure spring to be annotation driven.. see beans.xml for deails 
* Inside of web.xml, configure the following:
	* Declare our DispatcherServlet as the single servlet in the app
	* configure context loader listener
	* configure servlet context params 
* Create your controllers -- anotate with either @Controller or @RestController 
* Deploy to Tomcat Server
