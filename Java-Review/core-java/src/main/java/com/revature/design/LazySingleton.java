package com.revature.design;

public class LazySingleton {
	
	
	//ONLY DECLARE
	//instantiate when asked
	private static LazySingleton instance;
	
	{
		System.out.println("this is a non-static"
				+ "block of code in the Lazy Singleton class ");
	}
	
	
	private LazySingleton() {
		System.out.println("constructing lazy singleton");
	}
	
	public static LazySingleton getInstance() {
		if(instance == null) {
			instance = new LazySingleton();
		}
		return instance;
	}
	
	public static void test() {
		System.out.println("loading lazy singleton");
	}

}
