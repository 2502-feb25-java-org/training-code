package com.revature.core;

public class ControlStatements {
	
	/*
	 * Control statements in Java affect the flow of your application 
	 * This includes loops, ifs, whiles, switch, etc
	 * 
	 * You know most of this, but here's the weird stuff:
	 */
	
	public static void main(String[] args) {
		
		System.out.println(ternary(11));
		
	}
	
	static String ternary(int x) {
		// [condition] ? [value if true] : [value if false]
		int y = x > 10? 1 : 100;
		
		return x > 10 ? "x is greater than 10" : "it is not greater than 10";
	}
	
	static void testIf(int x) {
		if(x == 5) { //if(condition OR expression)
			
		}
	}
	
	/*
	 * SWITCH Cases:
	 * - used to test a single var value against 
	 * other concrete options 
	 * - we cannot use all data types with a switch case 
	 * - can only use Strings, enums, ints(and all primitives 
	 * that can be cast up to an int -- short, byte, char), 
	 * and their respective wrapper classes
	 */
	static void testSwitch(String x) {
		switch(x) {
		case "hello":
			break;
		case "World":
			
		case "goodbye":
		default: 
			System.out.println("at end of switch statement");
			
		}
	}
	
	static void testFor(int i) {
		for( ; ; ) {
			if(i%2==0) {
				i++;
			}
			if(i%2==1) {
				i+=3;
			}
			
			if(i > 30) {
				break;
			}
		}
	}

}
