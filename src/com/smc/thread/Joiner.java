package com.smc.thread;

public class Joiner extends Thread{

	private Sleeper sleeper;
	
	public Joiner(String name, Sleeper sleeper){
		super(name);
		this.sleeper = sleeper;
		start();
	}
	
	@Override
	public void run() {
		
		try {
			sleeper.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(getName() + "join completed");
	}
	
	public static void main(String[] args) {
		Sleeper sleepy = new Sleeper("Sleepy", 1500);
		Joiner dopey = new Joiner("Dopey", sleepy);
		
		Sleeper grumpy = new Sleeper("Grumpy", 1500);
		Joiner doc = new Joiner("Doc", grumpy);
		grumpy.interrupt();
	}
}
