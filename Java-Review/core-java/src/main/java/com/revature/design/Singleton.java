package com.revature.design;

public class Singleton {
	
	/*
	 * The Singleton design pattern is used in scenarios 
	 * which require one and only one instance of an object 
	 * to be created 
	 * 
	 * This typically means that the class with have a PRIVATE 
	 * constructor and a public getInstance() method that 
	 * returns the single instance of the object 
	 */
	
	public String name; //for demonstrating that all references will be to a single instanc e

	static {
		System.out.println("This is a static block");
	}
	
	{
		System.out.println("this is a non-static"
				+ "block of code in the Singleton class ");
	}
	
	static {
		System.out.println("this is a static"
				+ "'initializer' block that "
				+ "executes as soon as the class "
				+ "is loaded ");
	}
	
	private static Singleton instance
		= new Singleton();
	
	private Singleton() {
		System.out.println("constructing Singleton"
				+ " object");
	}
	
	public static Singleton getInstance() {
		return instance;
	}
	
	
	static void test() {
		System.out.println("loading our Eager Singleton class");
	}
	

}
