package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.pojos.User;
import com.revature.service.UserService;

@WebServlet(loadOnStartup=2, urlPatterns= {"/users"})
public class UserServlet extends HttpServlet{

	/*
	 * Creating a RESTful servlet... will discuss more of this later 
	 */
	static UserService service = new UserService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<User> users = service.getAll();
		
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(users);
		
		PrintWriter writer = resp.getWriter();
		resp.setContentType("application/json");
		
		writer.write(json);
		
	}
	
	
	
}
