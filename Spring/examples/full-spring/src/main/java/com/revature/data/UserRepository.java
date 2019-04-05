package com.revature.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.model.Role;
import com.revature.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	User findByUsernameIgnoreCase(String username);
	
	User findByUsernameIgnoreCaseAndPassword(String username, String password);
	
	List<User> findByRole(Role role);
	
}
