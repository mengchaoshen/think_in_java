package com.smc.thread;

public class MoreBasicThreads {

	public static void main(String[] args) {

//		for(int i =0; i<5; i++){
//			new Thread(new LiftOff()).start();
//		}
//		System.out.println("Waiting for Liftoff");
		
//		for(int i = 0; i<5; i++){l 
//			new Thread(new Practice21_2_2()).start();
//		}
		
		for(int i = 1; i< 8; i++){
			new Thread(new Fibonacci(i)).start();
		}   
	}

}
