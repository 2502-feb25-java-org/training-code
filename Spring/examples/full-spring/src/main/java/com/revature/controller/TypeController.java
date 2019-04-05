package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.data.TypeRepository;
import com.revature.model.Type;

@RestController
@RequestMapping("/type")
public class TypeController {

	@Autowired
	TypeRepository tRepo;
	
	@RequestMapping(method=RequestMethod.POST,
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Type> add(@RequestBody Type t){
		return new ResponseEntity<Type>(tRepo.save(t), HttpStatus.CREATED);
	}
	
	@RequestMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Type>> getAll(){
		return new ResponseEntity<List<Type>>(tRepo.findAll(), HttpStatus.OK);
	}
	
	
	
}
