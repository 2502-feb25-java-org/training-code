package com.revature.oop;

public class Inheritance implements A, B {

	@Override
	public void abstractMethod() {
		// TODO Auto-generated method stub
		
		System.out.println("this is the overriden abstract method in "
				+ "the inheritance class");

	}

	@Override
	public void testDefault() {
		System.out.println("this is the overriden testDefault() "
				+ "the inheritance class");
	}

}

interface A{

	void abstractMethod();

	default void interfaceA() {
		System.out.println("method only found in interface A");
	}
	static void testStatic() {
		System.out.println("interface A testStatic");

	}

	default void testDefault() {
		System.out.println("interface A testDefault");
	}

}

interface B{
	
	static void testStatic() {
		System.out.println("interface B  testStatic");
	}
	default void testDefault() {
		System.out.println("interface B testDefault");
	}
}


