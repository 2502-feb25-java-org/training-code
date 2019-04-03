package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.data.UserRepository;
import com.revature.model.User;

/*
 * The service layer is simply a design pattern best practice 
 * where we have an intermediary "layer" (class/set of classes)
 * between our data persistence/access layer(DAOs) and our exposure
 * layer (servlets/controllers)
 * 
 * These service classes are where we hold our business logic for 
 * an app. but for simple apps we may simply end up calling 
 * all of our dao methods here without any extra functionality 
 * 
 * we can propagate our transactions from the service layer 
 * to dao layer with our tx propagation strategies, which we 
 * will cover later
 */

@Service
public class UserService {
	
	@Autowired
	UserRepository repo;
	
	public User getById(int id) {
		return repo.getById(id);
	}

	public List<User> getAllUsers(){
		return repo.getAll();
	}
	
	public User addUser(User u) {
		if(u.getUsername() == null || u.getPassword() == null) {
			return null;
		}
		else if(repo.getByUsername(u.getUsername())!= null) {
			//username already exists
			return null;
		}
		else {
			return repo.save(u);
		}
		
	}
	
}
