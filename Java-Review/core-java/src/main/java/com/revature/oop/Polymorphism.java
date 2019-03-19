package com.revature.oop;

public class Polymorphism {

	int x;
	int y;

	public Polymorphism(){
		this(5);
	}

	public Polymorphism(int xVar) {
		//implicitly calling super()
		x = xVar;
	}


	public static void main(String[] args) {
		Baap b = new Beta();
		System.out.println(b.h + " " + b.getH());
		Beta bb = (Beta) b;
		System.out.println(bb.h + " " + bb.getH());
	}
}

class Baap{
	public int h = 4;
	public int getH() {
		System.out.println("Baap " + h);
		return h;
	}
}
class Beta extends Baap{
	public int h = 44;
	public int getH() {
		System.out.println("Beta " + h);
		return h;
	}
	
	public void test() {
		
	}
}
