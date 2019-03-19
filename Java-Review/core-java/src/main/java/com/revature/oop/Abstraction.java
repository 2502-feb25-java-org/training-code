package com.revature.oop;

public class Abstraction {
	
	/*
	 * prior to Java8, interfaces were only able to have 
	 * abstract methods, but now we see the intro of default
	 * methods in interfaces, which really serve as standard 
	 * functionality for every implementing class
	 * 
	 */

}



interface Marker{
	/*
	 * These simply denote something as the case 
	 * there are no methods in a marker interface
	 */
}

@FunctionalInterface //not necessary but it exists 
interface Functional{
	/*
	 * Functional interfaces, popularized with Java 8, 
	 * are interfaces with one and only one 
	 * abstract method!!!!!!!!!!!!!!!!!!!!!!!!!!
	 * 
	 * Can have as many default methods as you want
	 * and static 
	 */
	int calculate(int... nums);
	
	static void testStatic() {
		
	}
	
	default void doOtherThings() {
		
	}
	
}
