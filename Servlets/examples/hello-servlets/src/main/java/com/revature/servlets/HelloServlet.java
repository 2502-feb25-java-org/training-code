package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.log4j.Logger;

public class HelloServlet extends GenericServlet{
	
	/*
	 * Log4j - a logging tool for Java
	 * - use this instead of basic sysouts 
	 */
	private static Logger log =  Logger.getLogger(HelloServlet.class);
	//LIFECYCLE STEP 1 - INIT
	@Override
	public void init() throws ServletException {
		super.init();
		log.trace("INITIALIZING"
				+ " GENERIC SERVLET");
	}

	
	//STEP 2 - SERVICE
	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		log.trace("IN HELLO SERVLET (GENERIC SERVLET) SERVICE METHOD!");
		
		PrintWriter writer = res.getWriter();
		
		//get servlet params and add to our response
		String context = getServletContext()
				.getInitParameter("environmentVar");
		
		writer.write("Hello Servlet World!");
		
	}
	//STEP 3 - DESTROY
	@Override
	public void destroy() {
		super.destroy();
		log.trace("DESTROYING GENERIC SERVLET");
	}


}
