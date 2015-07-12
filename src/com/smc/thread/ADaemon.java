package com.smc.thread;

import java.util.concurrent.TimeUnit;

public class ADaemon implements Runnable {

	@Override
	public void run() {

		try {
			System.out.println("Starting ADaemon");
			TimeUnit.MILLISECONDS.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			System.out.println("This should always run?");
		}
	}
	
	public static void main(String[] args) {
		Thread t = new Thread(new ADaemon());
//		t.setDaemon(true);
		t.start();
		try {
			TimeUnit.MILLISECONDS.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
