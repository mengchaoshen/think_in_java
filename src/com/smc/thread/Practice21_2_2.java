package com.smc.thread;

public class Practice21_2_2 implements Runnable{

	private static int taskCount = 0;
	private final int id = taskCount++;
	
	public Practice21_2_2(){
		System.out.println("Practice21_2_2 started ID="+id);
	}
	
	@Override
	public void run() {
		
		System.out.println("Stage 1...Id = "+id);
		Thread.yield();
		System.out.println("Stage 2...Id = "+id);
		Thread.yield();
		System.out.println("Stage 3...Id = "+id);
		Thread.yield();
		System.out.println("Practice21_2_2 ended");
		
	}

}
