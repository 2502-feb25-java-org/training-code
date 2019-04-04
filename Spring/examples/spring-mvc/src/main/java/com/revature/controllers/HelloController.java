package com.revature.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller //registers our class as a bean that can handle HTTP requests
@RequestMapping("/test") //this annotation mean that now all requests to /test will come here
public class HelloController {
	
	@RequestMapping(method=RequestMethod.GET)
	@ResponseBody //necessary annotation when using @Controller to indicate that what is returned from this method is the response body and not the name of a resource to be resolved
	public String home() {
		return "Welcome to Spring MVC!";
	}
	
	
	@RequestMapping(value="/pattern", method=RequestMethod.GET)
	@ResponseBody
	public String moreMappings() {
		return "This is a different GET request";
	}

}
