package com.revature.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeController {

	@RequestMapping
	public String test() {
		return "Welcome to spring boot!";
	}
}
