package com.revature.oop;

public class Encapsulation {
	
	private int id;
	private String data;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		if(id<0) { //do something 
			
		}
		this.id = id;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	
	
	

}
