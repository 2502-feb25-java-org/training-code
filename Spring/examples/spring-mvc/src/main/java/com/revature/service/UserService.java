package com.revature.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.model.User;

/*
 * @Service is a specialization of @Component
 * It can only be applied to classes
 * It is used to mark the class as a service provider
 */
@Service
public class UserService {
	
	//Dummy user service. will store data in static arraylist 
	
	private static List<User> users = new ArrayList<User>();
	private static int lastId = 3;
	
	static {
		users.add(new User(1, "genesis", "123" ));
		users.add(new User(2, "admin", "admin"));
		users.add(new User(3, "springframework", "is amazing!"));
	}
	
	//CREATE
	public User save(User u) {
		u.setId(++lastId);
		users.add(u);
		return u;
	}
	
	//READ
	public List<User> getAll(){
		return users;
	}
	
	public User getById(int id) {
		return users.stream().filter(u -> u.getId()==id).findFirst()
				.orElse(null);
	}
	
	//UPDATE
	public User update(User u) {
		User removed = getById(u.getId());
		if(removed == null) return null;
		users.remove(removed);
		users.add(u);
		return u;
	}
	
	//DELETE
	public User delete(User u) {
		int id=-1;
//		for(User user : users) {
//			if(user.getId()==u.getId()) {
//				id=users.indexOf(user);
//			}
//		}
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getId()==u.getId()) {
				id = i;
				break;
			}
		}
		if(id>-1) {
			users.remove(id);
			return null; //this means a user was found and deleted
		}
		else return u; //means that user did not exist in list (by id)
	}

}
