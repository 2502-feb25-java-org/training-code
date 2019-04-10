package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Customer;
import com.revature.repositories.CustomerRepository;

@RestController
@RequestMapping(value="/customers")
public class CustomerController {

	@Autowired
	CustomerRepository custRepo;
	
	@RequestMapping(method=RequestMethod.GET, 
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Customer>> getAll(){
		return new ResponseEntity<List<Customer>>(custRepo.findAll(), HttpStatus.OK);
	}
	
}
