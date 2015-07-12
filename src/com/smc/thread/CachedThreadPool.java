package com.smc.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPool {

	public static void main(String[] args) {

//		ExecutorService exec = Executors.newCachedThreadPool();
//		
//		for(int i = 0; i<5;i++){
//			exec.execute(new LiftOff());
//		}
//		exec.shutdown();
		
		ExecutorService exec = Executors.newCachedThreadPool();
		for(int i = 1; i<=5; i++){
//			exec.execute(new Practice21_2_2());
			exec.execute(new Fibonacci(i));
		}
		exec.shutdown();
	}

}
