package com.revature.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.data.UserRepository;
import com.revature.model.User;

public class DataApp {

	public static void main(String[] args) {
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("beans.xml");
		UserRepository repo = (UserRepository)
				context.getBean(UserRepository.class);
//		System.out.println("THERE ARE " + repo.count() + "USERS");
//		System.out.println(repo.findAll());
		
	//	User u = new User("SPRING DATA", "IS AWESOME");
		//repo.save(u);
//		
//		repo.save(new User("test", "user"));
//		repo.save(new User("long username here", "password"));
//		
//		User u = repo.findByUsernameIgnoreCaseAndPassword("spring data", "IS AWESOME");
		System.out.println(repo.lengthQuery(2, 10));
	}

}
