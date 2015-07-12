package com.smc.thread;

public class Sleeper extends Thread{
	
	private int duration;
	
	public Sleeper(String name, int sleepTime){
		super(name);
		this.duration = sleepTime;
		start();
	}
	
	@Override
	public void run() {
		try {
			sleep(duration);
		} catch (InterruptedException e) {
//			e.printStackTrace();
			System.out.println(getName() + " was interrupted." +" isInterrupted()" + isInterrupted());
			return;
		}
		System.out.println(getName() + "has awakened");
	}
}

