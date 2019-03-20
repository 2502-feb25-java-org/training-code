package com.revature.design;

public class Factory {
	
	/*
	 * The factory design pattern is a pattern which 
	 * creates objects where the precise type may not 
	 * be known until runtime (create a reference to a
	 * parent class or interface but instantiate with 
	 * the particular implementing class based on some 
	 * sort of user input)
	 * 
	 * To make a factory we need:
	 * - abstract data type
	 * - classes which inherit the abstract data type
	 * - static method that returns a concrete instance
	 * of the abstract data type
	 */	
	
	public static Dessert getDessert(String type) {
		switch(type) {
		case "cake": return new Cake(); 
		case "brownie": return new Brownie();
		case "cookie": return new Cookie();
		default: throw new DessertNotFoundException();
		}
	}

}

class DessertNotFoundException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID 
		= -7069892270752083288L;

	public DessertNotFoundException() {
		super("Did not enter a valid dessert option!");
	}
}

interface Dessert{
	String bake();
}


class Cake implements Dessert{
	@Override
	public String bake() {
		return "bake red velvet!";
	}
}

class Cookie implements Dessert{

	@Override
	public String bake() {
		return "everyone loves chocolate chip!"; 
	}
}

class Brownie implements Dessert{
	@Override 
	public String bake() {
		return "i love brownies";
	}
}




