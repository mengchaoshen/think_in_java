package com.smc.thread;

import java.util.concurrent.TimeUnit;

public class SimpleDaemons implements Runnable {

	public static void main(String[] args) {

		for(int i = 0; i< 10; i++){
			Thread daemon = new Thread(new SimpleDaemons());
			daemon.setDaemon(true);
			daemon.start();
		}
		System.out.println("All daemons starts");
		try {
			TimeUnit.MILLISECONDS.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void run() {
		try {
			while (true) {
				TimeUnit.MILLISECONDS.sleep(100);
				System.out.println(Thread.currentThread() + " " + this);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
