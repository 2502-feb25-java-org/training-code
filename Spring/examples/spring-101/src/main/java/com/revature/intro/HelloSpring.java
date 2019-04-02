package com.revature.intro;

public class HelloSpring {
	/*
	 * This will be our first Spring bean!
	 * A Spring bean is simply a class managed by the 
	 * spring container
	 * We will allow the Spring container aka the IoC 
	 * container to instantiate this class, and inject
	 * its dependencies 
	 * 
	 * Spring beans must follow the standard convention 
	 * of having a public no-args contructor. In addition, 
	 * if there are instance variables that we will use 
	 * setter injection for, we must follow the standard 
	 * naming convention setVarName(). 
	 */
	
	private String message;
	
	public HelloSpring() {
		System.out.println("INSTANTIATING HELLO SPRING");
	}
	
	public HelloSpring(String message) {
		super();
		this.message = message;
		//System.out.println("CALLING CONSTRUCTOR WITH FIELDS");
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		System.out.println("USING SETTER INJECTION");
		this.message = message;
	}

	@Override
	public String toString() {
		return "HelloSpring [message=" + message + "]";
	}
	
	

}
