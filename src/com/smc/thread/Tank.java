package com.smc.thread;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Tank {
	
	private int count = 0;
	
	private Status status = Status.EMPTY;
	
	public enum Status{
		
		EMPTY, LOADED;
	}
	
	public synchronized void volidate(){
		if((0 == count && status == Status.LOADED) || (0 != count && status == Status.EMPTY)){
//			System.out.println("IllegalStateException");
			throw new IllegalStateException();
		}
	}
	
	public synchronized void fill(){
		count = 10;
		Thread.yield();
		status = Status.LOADED;
	}
	
	public synchronized void drain(){
		count = 0;
		Thread.yield();
		status = Status.EMPTY;
	}

	public static void main(String[] args) {
		Thread.setDefaultUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
		System.out.println("Press Control-C to exit");
		ExecutorService exec = Executors.newCachedThreadPool();
		Tank tank = new Tank();
		for(int i =0; i<10; i++){
			exec.execute(new ConsistencyChecker(tank));
		}
		Thread.yield();
		exec.shutdown();
	}
}

class ConsistencyChecker implements Runnable{

	private Random r = new Random(System.currentTimeMillis());
	
	private Tank tank;
	
	public ConsistencyChecker(Tank tank){
		this.tank = tank;
	}
	
	@Override
	public void run() {
		
		while(true){
			if(r.nextBoolean()){
				tank.drain();
			}else{
				tank.fill();
			}
			tank.volidate();
		}
	}
	
}
