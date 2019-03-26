package com.revature.service;

import com.revature.data.UserDAO;
import com.revature.model.User;

public class UserService {
	
	static UserDAO dao = new UserDAO();
	 
	/*
	 * What this method will do is take the only two credentials 
	 * present at login (username and password) and validate 
	 * that a user with this username exists, then validate
	 * said user's password if they do
	 * 
	 * We can pass in solely a username and pw string, or we 
	 * could pass in an entire User object with no ID or BIO fields 
	 * All up to you, but just make sure your servlet layer 
	 * passes the right values in	
	 */
	public User logIn(String username, String password) {
		User u = dao.getByUsername(username);
		if(u == null) {
			return null; //no user by username
		}
		else {
			if(u.getPassword().equals(password)) {
				return u; //success!
			}
			else {
				return null; //password does not match 
			}
		}
	}
	
	public User addUser(User u) {
		if(dao.getByUsername(u.getUsername())==null) {
			//now we know the username is unique. can add user!
			return dao.addUser(u);
		}
		else {
			return null; //username already used
		}
	}

}
