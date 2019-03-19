package com.revature.oop;

public class OOPDriver {

	public static void main(String[] args) {
		Inheritance inherit = new Inheritance();
		inherit.testDefault();
		inherit.interfaceA();
		
		A.testStatic();
		B.testStatic();
		
		A a = new Inheritance();
	}
}
