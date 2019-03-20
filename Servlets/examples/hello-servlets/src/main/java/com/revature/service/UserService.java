package com.revature.service;

import java.util.ArrayList;
import java.util.List;

import com.revature.pojos.User;

public class UserService {
	/*
	 * Dummy user service to explore servlet functionality 
	 * usually, this service layer would call classes from our 
	 * DAO (Data Access Object) layer - which is where we would 
	 * write methods to speak to our DB
	 * 
	 * for the sake of not overcomplicating this app, we will 
	 * simply use an in-memory store of users 
	 */
	
	private static List<User> users = new ArrayList<User>();
	
	static {
		users.add(new User("genesis", "123", "awesome trainer. she's great"));
		users.add(new User("patrick", "manager", "he manages things"));
	}
	
	public List<User> getAll(){
		return users;
	}
	
	public User getByUsername(String name) {
		/*
		for(User u : users) {
			if(name.equalsIgnoreCase(u.getUsername())) {
				return u;
			}
		}
		return null; */
		
		return users.stream()
		.filter( u -> u.getUsername().equalsIgnoreCase(name))
		.findFirst()
		.orElse(null);
	}
}
