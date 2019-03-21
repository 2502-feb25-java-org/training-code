package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

@WebServlet("*.view")
public class LoadViewServlet extends HttpServlet{
	private static Logger log = Logger.getLogger(LoadViewServlet.class);

	/* 
	 * 
	 * Here, we will FORWARD html pages as a response 
	 * 
	With servlets, we may not always want to simply 
	return some information as text, we may want to
	navigate to a different servlet, or to forward a 
	resource(html, jsp, etc) as a response 

	There are two ways to move between our resources:
	Forward - client sends a request to server with a 
	    URL /a. Servlet forwards the same req/resp pair
	    to a servlet B. but the client is unaware of this
	    as the path is still /a when response gets returned
	    - original req/resp pair gets returned, 
	    - URL does not change 
	    - req.getRequestDispatcher.forward();
	    - the RequestDispatcher is an interface whose 
	    implementation defines an object which can dispatch the 
	    request to any resources on the server 
	Redirect - client sends a request /a. servlet responds with 
	    a status code of 300-399 and instructions to send a 
	    new request to /b. client sends a request to /b and 
	    the client path is now at /b 
	    - in sum, we see a url change for client, good for login
	    - new req/resp pair 
	    - resp.sendRedirect();
	 */

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {

		/* 
		 * FORWARDS
		 * The HttpServletRequest interface has a method, getRequestDispatcher(),
		 * that returns a RequestDispatcher interface, which has a method, forward()
		 * to forward the request to another path
		 * The RequestDispatcher object acts as a wrapper for the resource 
		 * located at the given path
		 * The object can be used to forward a request to the resource or 
		 * to include the resource in a response 
		 * 
		 * 
		 * FRONT CONTROLLER DESIGN PATTERN 
		 * Design pattern in servlets where a single servlet takes in all requests 
		 * (or all requests of a particular pattern) and dispatches them to appropriate 
		 * help methods/classes 
		 */
		log.info("REQUEST SENT TO URI: " + req.getRequestURI());
		
		
		//	log.info("URL: " + req.getRequestURL());
		
		/*
		 * while we could use our lovely getResource method below, we can also
		 * simply parse our URI to get the vital info -- our resource name 
		 * if we send requests to X.view, where X is the name of the intended
		 * .html partial we want to retrieve, we can streamline the process
		 * of returning partial views and not need to worry about a switch case
		 */
		String uri = req.getRequestURI();
		String name = uri.substring(16, (uri.length()-5));
		log.info("TESTING URI " + name);
		req.getRequestDispatcher("partials/"+name+".html").forward(req, resp);

	}

	//no longer need 
	private String getResource(String uri) {
		String resource = "partials/";
		switch(uri) {
		case "/hello-servlets/landing.view" : 
			resource+="landing.html";
			break;

		case "/hello-servlets/home.view" :
			resource+="homepage.html";
			break;

		}
		return resource;
	}
}
