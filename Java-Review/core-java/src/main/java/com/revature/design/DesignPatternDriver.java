package com.revature.design;

import java.util.Scanner;

public class DesignPatternDriver {

	
	
	public static void main(String[] args) {
		factory();
	}
	
	static void factory() {
		System.out.println("Hey! What kind of dessert do you want?");
		
		Scanner scanner = new Scanner(System.in);
		String dessert = scanner.nextLine();
		
		Dessert des = Factory.getDessert(dessert);
		System.out.println(des.bake());
	}
	
	static void eagerVSLazy() {
		LazySingleton.getInstance();
	}
	
	static void testSingleton() {
		Singleton single = Singleton.getInstance();
		single.name = "First singleton!";
		
		Singleton single2 = Singleton.getInstance();
		single2.name = "Second singleton!";
		
		System.out.println("First singleton name = " 
		+ single.name);
		System.out.println("Second singleton name = " 
		+ single2.name);;
	}
}
