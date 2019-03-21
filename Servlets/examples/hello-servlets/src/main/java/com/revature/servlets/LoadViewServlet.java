package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loadView")
public class LoadViewServlet extends HttpServlet{

	
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
		
		/* FORWARDS
        
		 * The HttpServletRequest interface has a method, getRequestDispatcher(),
		 * that returns a RequestDispatcher interface, which has a method, forward()
		 * to forward the request to another path
		 * The RequestDispatcher object acts as a wrapper for the resource 
		 * located at the given path
		 * The object can be used to forward a request to the resource or 
		 * to include the resource in a response 
		 */
		
		req.getRequestDispatcher("partials/landing.html").forward(req, resp);
		
	}
		
}
