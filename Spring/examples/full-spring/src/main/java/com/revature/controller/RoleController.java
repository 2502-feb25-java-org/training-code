package com.revature.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.data.RoleRepository;
import com.revature.model.Role;

@RestController
@RequestMapping("/role")
public class RoleController {

	
	@Autowired
	RoleRepository rRepo;
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Role> add(@RequestBody Role role){
		return new ResponseEntity<Role>(rRepo.save(role), HttpStatus.CREATED);
	}
}
