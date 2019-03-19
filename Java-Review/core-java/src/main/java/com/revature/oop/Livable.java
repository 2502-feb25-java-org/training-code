package com.revature.oop;

public interface Livable {
	
	/*
	 * in interfaces, the two default modifiers applied to each method are
	 * public abstract 
	 * 
	 * VARIABLES are public static final 
	 * 
	 */
	
	void eat();
	
	static void test() {
		System.out.println("can also have static implementations");
	}
	
	default void notAbstract() {
		System.out.println("This is method implementation!");
	}
	

}
