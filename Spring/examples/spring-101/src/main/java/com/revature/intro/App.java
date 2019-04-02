package com.revature.intro;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {

		// HERE, we are instantiating our instance ourself. so no spring!
		HelloSpring notSpring = new HelloSpring();
		System.out.println(notSpring.getMessage());
		
		//Here, we are using spring! 
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		HelloSpring spring = (HelloSpring) context.getBean("myFirstBean");
		System.out.println(spring.getMessage());
		
		System.out.println("------------------exploring bean wiring------------------------");
		
		ParentBean p1 = (ParentBean) context.getBean(ParentBean.class);
		System.out.println(p1.getDependency().getMessage());
		
		ParentBean notASpringBean = new ParentBean();
		System.out.println("This is what would happen if we attempted to retrieve"
				+ " our dependency when we instantiate our bean without spring... " + 
				notASpringBean.getDependency().getMessage()); //throws NullPointerException
	}

}
