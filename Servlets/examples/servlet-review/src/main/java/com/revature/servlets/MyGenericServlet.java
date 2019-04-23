package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/*
 * This is a Generic Serlvet, parent class
 * of HttpServlet
 * 
 * We will explore the differences between the two 
 * 
 * GenericServlets can process requests that 
 * the application receives from ANY transfer protocol!
 * 
 * This is nice, as we can process more types of requests, 
 * but the con is that we cannot leverage the extra
 * functionality of HTTP even if the request is an HTTP request
 * 
 * in generic servlets, we MUST**** override the service() method
 */
public class MyGenericServlet extends GenericServlet{

	@Override
		public void init() throws ServletException {
			System.out.println("INTIALIZING GENERIC SERVLET");
		}
	
	
	@Override
	public void service(ServletRequest req, ServletResponse res) 
			throws ServletException, IOException {
	
		//this is an object that we can use to write responses
		PrintWriter writer = res.getWriter();
		
		writer.write("HELLO SERVLETS!");
		
	}

}
