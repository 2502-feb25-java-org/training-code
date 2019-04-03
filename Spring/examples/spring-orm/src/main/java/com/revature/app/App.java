package com.revature.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.model.Post;
import com.revature.model.User;
import com.revature.service.PostService;
import com.revature.service.UserService;

public class App {

	
	public static void main(String[] args) {
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("beans.xml");
		
		UserService	 service = (UserService) context.getBean(UserService.class);
		
	//	System.out.println(service.getAllUsers());
		
		PostService postService = (PostService) context.getBean(PostService.class);
		
		User u = service.getById(5);
	//	System.out.println(u);
		
		Post p = new Post();
		p.setSubject("Spring");
		p.setBody("Spring is a Java framework used to build EE Applications quickly and efficiently. It uses Dependency Injection");
		p.setAuthor(u);
		postService.save(p);
		
		
		System.out.println("GETTING ALL POSTS BY USER "+ u  + "\n" + postService.getByAuthor(u) );
	}
}
