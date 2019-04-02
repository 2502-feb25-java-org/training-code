package com.revature.intro;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {

		// HERE, we are instantiating our instance ourself. so no spring!
		HelloSpring spring = new HelloSpring();
		System.out.println(spring.getMessage());
		
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		spring = (HelloSpring) context.getBean("myFirstBean");
		System.out.println(spring.getMessage());
		
	}

}
