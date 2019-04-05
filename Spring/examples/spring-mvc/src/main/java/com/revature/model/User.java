package com.revature.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

/*
 * Exploring JSR-303 (Bean validation)
 * - the specification of the Java API for JavaBean validation
 * - it provides an easy way of ensuring that the properties of 
 * your beans have the right values in them
 * 
 */

@Component
public class User {
	
	private int id;
	
	@NotNull
	@Pattern(regexp="[a-z-A-Z]*")
	@Size(min=5)
	private String username;
	private String password;
	
	public User() {}
	
	public User(int id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
