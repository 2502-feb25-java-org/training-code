package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Account;
import com.revature.repository.AccountRepository;

@RestController
public class AccountController {
	
	@Autowired
	AccountRepository accRepo;
	
	public ResponseEntity<List<Account>> getAll(){
		return new ResponseEntity<List<Account>>(accRepo.findAll(), HttpStatus.OK);
	}

}
