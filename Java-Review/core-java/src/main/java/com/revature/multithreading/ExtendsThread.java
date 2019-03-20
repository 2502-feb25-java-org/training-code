package com.revature.multithreading;

public class ExtendsThread extends Thread{
	
	@Override
	public void run() {
		Thread et = Thread.currentThread();
		for(int i = 0; i < 20; i++) {
			System.out.println("ET: " + i);
		}
	}

}
