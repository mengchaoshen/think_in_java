package com.smc.thread;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SleepingTask2 implements Runnable{
	
	private static Random random = new Random();
	private final int sleep_time = random.nextInt(10) + 1;
	
	
	@Override
	public void run() {
		
		try {
			TimeUnit.SECONDS.sleep(sleep_time);
			System.out.println(sleep_time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		
		ExecutorService exec = Executors.newCachedThreadPool();
		
		for(int i = 0; i < 5; i++){
			exec.execute(new SleepingTask2());
		}
		Thread.yield();
		exec.shutdown();
		
	}
	

}
