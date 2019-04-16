package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.data.AccountRepository;
import com.revature.model.Account;

@RestController
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	AccountRepository accRepo;
	
	
	@RequestMapping
	public List<Account> getAll(){
		return accRepo.findAll();
	}

}
