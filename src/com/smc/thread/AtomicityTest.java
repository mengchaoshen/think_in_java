package com.smc.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AtomicityTest implements Runnable{

	private int i = 0;
	
	public int getValue(){
	
		return i;
	}
	
	public synchronized void evenIncrement(){
		i++;
		i++;
	}
	
	
	
	public static void main(String[] args) {

		AtomicityTest at = new AtomicityTest();
		ExecutorService exec = Executors.newCachedThreadPool();
		exec.execute(at);
		while(true){
			int val = at.getValue();
			if(val % 2 != 0){
				System.out.println(val);
				System.exit(0);
			}
		}
	}

	@Override
	public void run() {
		while(true){
			evenIncrement();
		}
	}

}
