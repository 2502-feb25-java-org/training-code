package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class HelloServlet extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		System.out.println("IN HELLO SERVLET (GENERIC SERVLET) SERVICE METHOD!");
		
		PrintWriter writer = res.getWriter();
		
		writer.write("Hello Servlet World!");
		
	}

}
