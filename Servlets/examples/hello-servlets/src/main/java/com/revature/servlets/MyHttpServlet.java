package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.revature.pojos.User;
import com.revature.service.UserService;

//make accessible at endpoint http
public class MyHttpServlet extends HttpServlet{
	
	private static Logger log = Logger.getLogger(MyHttpServlet.class);
	static UserService service = new UserService();	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		log.info("in Http Servlet --GET");
		PrintWriter writer = resp.getWriter();
		writer.write("GET METHOD RESPONSE");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		User user = service.getByUsername(username);
		
		PrintWriter writer = resp.getWriter();
		resp.setContentType("text/html");
		
		String output = "";
		
		if(user == null) {
			//no user exists 
			output = "<b>Incorrect user credentials. please go back!</b>";
		}
		else {
			//user exists. must check pw
			if(password.equals(user.getPassword())){
				//user has logged in successfully. HERE IS WHERE WE WOULD ADD USER TO SESSION
				output = "<h1>Welcome, " + user.getUsername() + 
						"!</h1> <br> " + user.getBio();
			}
			else {
				//unsuccessful log in with wrong pw 
				output = "<b>Incorrect user credentials. please go back!</b>";
			}
		}
		writer.write(output);
	}

}
