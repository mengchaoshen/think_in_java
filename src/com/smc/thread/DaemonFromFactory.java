package com.smc.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class DaemonFromFactory implements Runnable {

	public static void main(String[] args) {

		ExecutorService exec = Executors.newCachedThreadPool(new DaemonThreadFactory());
		for(int i = 0; i< 10; i++){
			exec.execute(new DaemonFromFactory());
		}
		System.out.println("All deamon started");
		try {
			TimeUnit.MILLISECONDS.sleep(500);
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
