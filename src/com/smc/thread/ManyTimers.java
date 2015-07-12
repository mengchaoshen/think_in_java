package com.smc.thread;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class ManyTimers {

	public static void main(String[] args) throws InterruptedException {

//		if(args.length < 1){
//			System.out.println("Usage: java E14_ManyTimers <num of timers>");
//		}
		
		int numberOfTimers = 100;
		for(int i = 0; i< numberOfTimers; i++){
			new Timer().schedule(new TimerTask() {
				
				@Override
				public void run() {

					System.out.println(System.currentTimeMillis());
				}
			}, numberOfTimers - i);
		}
		TimeUnit.MILLISECONDS.sleep(2 * numberOfTimers);
		System.exit(0);
	}

}
