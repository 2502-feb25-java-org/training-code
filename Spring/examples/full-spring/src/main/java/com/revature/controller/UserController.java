package com.revature.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.data.UserRepository;
import com.revature.model.User;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserRepository uRepo; //SHOULD BE SERVICE LAYER to follow best practices
	
	//ADD USER
	@RequestMapping(method=RequestMethod.POST, 
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> add(@RequestBody User user){
		user = uRepo.save(user);
		return new ResponseEntity<User>(user, HttpStatus.CREATED);
	}
	
	//GET ALL USERS
	
	//GET USER BY ID
	
	//GET USER WITH LOGIN CREDENTIALS
	
}
