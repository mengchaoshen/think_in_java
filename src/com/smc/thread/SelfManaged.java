package com.smc.thread;

public class SelfManaged implements Runnable{

	private Thread t = new Thread(this);
	private int countDown = 5;
	
	public SelfManaged(){
		t.start();
	}
	
	public static void main(String[] args) {

		for(int i = 0; i< 5; i++){
			new SelfManaged();
		}
	}

	@Override
	public String toString() {
		return Thread.currentThread().getName() + "(" + countDown + ")";
	}
	
	@Override
	public void run() {
		while(true){
			System.out.println(this);
			if( -- countDown == 0){
				return;
			}
		}
	}

}
