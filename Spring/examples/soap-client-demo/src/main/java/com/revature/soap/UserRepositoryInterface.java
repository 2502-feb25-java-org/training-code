package com.revature.soap;

import java.util.List;

import javax.jws.WebService;

@WebService
public interface UserRepositoryInterface {
	
	String getUser(int id);
	void addUser(String user);
	List<String> getAll();
	
}
