package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.data.CustomerRepository;
import com.revature.model.Customer;

@RestController
@RequestMapping(value="/customer")
public class CustomerController {

	@Autowired
	CustomerRepository custRepo;
	
	@RequestMapping(method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Customer> getAll(){
		return custRepo.findAll();
	}
	
}
