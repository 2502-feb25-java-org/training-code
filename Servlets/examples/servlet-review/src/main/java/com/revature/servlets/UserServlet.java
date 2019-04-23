package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/users")
public class UserServlet extends HttpServlet{
	
	static List<User> users = new ArrayList<User>();
	
	static {
		users.add(new User("Genesis", "Bonds"));
		users.add(new User("Patrick", "Walsh"));
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//get writer to write response
		PrintWriter writer = resp.getWriter();
		
		//set content type of response
		resp.setContentType("application/json");
		
		//get Object mapper object to turn response data into resp text
		ObjectMapper mapper = new ObjectMapper();
		
		//RESPONSE TEXT:
		String json = mapper.writeValueAsString(users);
		
		//respond
		writer.write(json);
	}
	
	//add user to list 
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// get mapper
		ObjectMapper mapper = new ObjectMapper();
		
		//get REQUEST body
		User u = mapper.readValue(req.getInputStream(), User.class);
		
		users.add(u);
	}

}



class User{
	
	String firstname; 
	String lastname;
	
	public User() {}
	
	public User(String firstname, String lastname) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	
}
