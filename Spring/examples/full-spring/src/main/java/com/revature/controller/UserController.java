package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.data.UserRepository;
import com.revature.model.User;

@RestController
@RequestMapping("/user")
@CrossOrigin
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
	@RequestMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<User>> getAll(){
		List<User> users = uRepo.findAll();
		if(users.isEmpty()) {
			return new ResponseEntity<List<User>>( HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
	
	//GET USER BY ID
	@RequestMapping(value="/{id}")
	public ResponseEntity<User> getById(@PathVariable int id) {
		User u = uRepo.findOne(id);
		if(u==null) {
			return new ResponseEntity<User>( HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<User>(u, HttpStatus.OK);
	}
	
	
	//GET USER WITH LOGIN CREDENTIALS
	
}
