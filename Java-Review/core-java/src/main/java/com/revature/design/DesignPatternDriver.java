package com.revature.design;

public class DesignPatternDriver {

	
	
	public static void main(String[] args) {
		eagerVSLazy();
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
