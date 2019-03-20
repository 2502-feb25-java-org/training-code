package com.revature.advanced;

public class GarbageCollector {
	
	private String name;
	
	public GarbageCollector(String name) {
		this.name = name;
	}

	@Override
	protected void finalize() throws Throwable {
		System.out.println(name + " -- goodbye cruel world!");
		super.finalize();
	}
	
}
