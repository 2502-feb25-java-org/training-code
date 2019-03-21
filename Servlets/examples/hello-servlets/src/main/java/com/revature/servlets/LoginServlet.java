package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.pojos.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	
	private static Logger log = Logger.getLogger(LoginServlet.class);

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// take in info from request, and return user if logged in properly, return null if not proper credentials
		
		//get request body -- req.getInputStream()  and use objectmapper to read value
		ObjectMapper mapper = new ObjectMapper();
		User inputUser = mapper.readValue(req.getInputStream(), User.class);
		
		log.info("attempting to log in user -- " + inputUser.toString());
	
		
		//consult service layer (call methods from th service class) . is username/password valid?
		
		//if so, return JSON string of user 
		
		//if not return null JSON String 
	}
}
