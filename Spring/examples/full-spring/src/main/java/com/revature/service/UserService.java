package com.revature.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.data.UserRepository;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepository userRepo;
	

	//pretend this has functionality ....
}
