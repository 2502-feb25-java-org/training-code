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

