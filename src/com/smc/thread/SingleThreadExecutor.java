package com.smc.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadExecutor {

	public static void main(String[] args) {

		ExecutorService exec = Executors.newSingleThreadExecutor();
		for(int i = 1; i <= 5; i++){
			exec.execute(new LiftOff());
//			exec.execute(new Practice21_2_2());
//			exec.execute(new Fibonacci(i));
		}
		exec.shutdown();
	}

}
