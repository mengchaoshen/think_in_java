package com.smc.thread;

import java.util.concurrent.TimeUnit;

public class InnerRunnable1 {

	private int countDown = 5;
	
	private Inner inner;
	
	public InnerRunnable1(String name){
		inner = new Inner(name);
	}
	
	private class Inner implements Runnable{

		private Thread t;
		
		public Inner(String name){
			t = new Thread(this, name);
			t.start();
		}
		
		@Override
		public void run() {
			try {
				while (true) {
					System.out.println(this);
					if (--countDown == 0) {
						return;
					}
					TimeUnit.MILLISECONDS.sleep(10);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		@Override
		public String toString() {
			return t.getName() + ": " +countDown;
		}
		
	}
	
}
