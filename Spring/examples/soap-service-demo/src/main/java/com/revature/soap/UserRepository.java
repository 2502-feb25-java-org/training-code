package com.revature.soap;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

@WebService(endpointInterface="com.revature.soap.UserRepositoryInterface")
public class UserRepository implements UserRepositoryInterface{
	
	static List<String> users = new ArrayList<String>();
	
	static {
		//using this in memory store to mimic persistence 
		users.add("Genesis");
		users.add("Patrick");
		users.add("Carolyn");
	}

	@Override
	public String getUser(int id) {
		return users.get(id);
	}

	@Override
	public void addUser(String user) {
		users.add(user);
	}

	@Override
	public List<String> getAll() {
		return users;
	}

}
