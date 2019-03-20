package com.revature.advanced;

import java.util.ArrayList;
import java.util.List;

public class MyGenericClass<T> {
	
	// we will use this to make a fake persistence layer
	
	/*
	 * Generic types allow us to manipulate objects 
	 * in other objects without knowing 
	 * what kind of object will be used until runtime 
	 */
	
	private List<T> objects = new ArrayList<T>();
	
	public List<T> getAll(){
		return objects;
	}
	
	public void add(T obj) {
		objects.add(obj);
	}
	
	public void getClassInfo() {
		//how to get class info of generic type at runtime 
	}

}
