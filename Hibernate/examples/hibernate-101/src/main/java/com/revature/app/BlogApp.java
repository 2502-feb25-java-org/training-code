package com.revature.app;

import com.revature.data.UserRepository;
import com.revature.model.User;

public class BlogApp {
	
	static UserRepository uDao = new UserRepository();
	
	public static void main(String[] args) {
		
		loadAndFollow();
	}
	
	static void createAndFollow() {
		User me = new User("genesisbonds", "password");
		User celeb = new User("Beyonce", "sashaf13rce");
		
		me = uDao.save(me); //detached entity with ID
		celeb = uDao.save(celeb);
		
		uDao.follow(me, celeb);
	}
	
	static void loadAndFollow() {
		User toFollow = uDao.get(21);
		User follower1 = uDao.get(5);
		User follower2 = uDao.get(6);
		
		uDao.follow(follower1, toFollow);
		uDao.follow(follower2, toFollow);
	}
	
	
	
	

}
