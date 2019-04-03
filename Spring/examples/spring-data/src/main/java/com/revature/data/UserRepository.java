package com.revature.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.model.User;


/*
 * Spring data takes a very opinionated approach to basic 
 * data persistence functionality
 * 
 * What does that mean?
 * Well, we dont actually need to write methods 
 * 
 * By creating an interface that extends JPA interface in the 
 * Spring data API, we inherit its functionality, and based on 
 * the Class and ID, we automatically have basic CRUD functionality
 * 
 * All other functionality is done via the parsing of method names
 * 
 * However, you can, of course, still write JPQL
 */


@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	/*
	 * The methods that our JPA repository provides to us
	 * are based on the entire set of data OR manipulates
	 * the data by ID. in order to query or manipulate
	 * data with an instance variable, we can simply 
	 * write methods with method names and allow 
	 * Spring Data to parse our method names into queries 
	 * based on naming conventions 
	 * More info here: https://docs.spring.io/spring-data/jpa/docs/current/reference/html/
	 */
	public User findByUsernameLikeIgnoreCase(String username);
	
	public User findByUsernameIgnoreCaseAndPassword(String username, String password);

}
