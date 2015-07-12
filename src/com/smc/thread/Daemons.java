package com.smc.thread;

import java.util.concurrent.TimeUnit;

public class Daemons {

	public static void main(String[] args) {

		Thread d = new Thread(new Daemon());
		d.setDaemon(true);
		d.start();
		System.out.println("d.isDaemon()" + d.isDaemon()+",");
		try {
			TimeUnit.MILLISECONDS.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	

}
