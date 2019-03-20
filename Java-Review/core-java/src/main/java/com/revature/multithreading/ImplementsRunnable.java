package com.revature.multithreading;

public class ImplementsRunnable implements Runnable{

	@Override
	public void run() {
		Thread ir = Thread.currentThread();
		for(int i = 0; i < 20; i++) {
			System.out.println("IR: " + i);
		}
	}

}
