package com.revature.advanced;

public class AdvancedDriver {

	
	public static void main(String[] args) {
		testingGarbage();
	}
	
	static void testingGarbage() {
		GarbageCollector a = new GarbageCollector("a");
		GarbageCollector b = new GarbageCollector("b");
		b = a;
		new GarbageCollector("no ref");
		System.gc(); //REQUESTS garbage collector 
		/*
		 * the GC does not clean up objects in use 
		 * it deallocates memory from unreferenced objects 
		 */
		System.out.println("doing things");
		System.out.println("doing more things");
		
		
	}
	
	static void testingGenerics() {
		MyGenericClass<String> strings = new MyGenericClass<String>();
		MyGenericClass<Integer> ints = new MyGenericClass<Integer>();
		
		strings.add("hello world!");
		strings.add("test");
		strings.add("" + 2);
		
		ints.add(10);
		
		strings.getClassInfo();
		ints.getClassInfo();
		
	}
}
