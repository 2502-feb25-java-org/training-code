package com.revature.oop;

import java.util.*;

import static java.lang.System.out;

public class OOPDriver {

	public static void main(String[] args) {
		
		out.println("test");
		
		List<Integer> list 
			= new ArrayList<Integer>();
		
		
		Functional add = (nums) -> {
			int sum = 0;
			for(int n : nums) {
				sum += n;
			}
			return sum;
		};
		
	
	}

	
	
	
	static void testInheritance() {
		Inheritance inherit = new Inheritance();
		inherit.testDefault();
		inherit.interfaceA();
		
		Inheritance.testingMoreStatic();
		inherit.testingMoreStatic();
		
		
		A.testStatic();
	//	B.testStatic();
		
		A a = new Inheritance();
	}
}
