package com.revature.lifecycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LifeApp {
	

	public static void main(String[] args) {

		//creating App context
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("beans.xml");
		
		//requesting bean from app context
		Lifecycle life = (Lifecycle) context.getBean("lifecycle");
		
		//using bean
		System.out.println("Doing things with my lifecycle class " + life.getLifecycle());
		
		//closing container
		((ConfigurableApplicationContext)context).close();
	}

}
