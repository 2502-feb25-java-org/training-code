package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.pojos.User;
import com.revature.service.UserService;


/*
 * The following annotation eliminates the need for registering
 * the class as a servlet in the web.xml.
 * The servlet takes parameters as well such as load on startup etc
 * If you do not add any parameters, you can simply add the 
 * url-pattern without a param name in the parenthesis 
 * 
 * Note: do NOT use this AND the xml for the same servlet
 * you can use both for different servlets in the same app. but do not 
 * assign more than one url-pattern to the same servlet 
 */

//@WebServlet(loadOnStartup=2, urlPatterns= {"/users"})
@WebServlet("/users")
public class UserServlet extends HttpServlet{

	/*
	 * Creating a RESTful servlet... will discuss more of this later 
	 */
	static UserService service = new UserService();
	private static Logger log = Logger.getLogger(UserServlet.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<User> users = service.getAll();
		
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(users);
		
		PrintWriter writer = resp.getWriter();
		resp.setContentType("application/json");
		
		writer.write(json);
		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		ObjectMapper mapper = new ObjectMapper();
		User user = mapper.readValue(req.getInputStream(), User.class);
		log.trace("ADDING USER: " + user.toString());
		user = service.addUser(user);
		if(user == null) {
			resp.setStatus(409);
		}
		else {
			resp.setStatus(201);
		}
	}
	
	
}
