package com.smc.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EvenChceker implements Runnable{

	private IntGenerator genertor;
	
	private final int id;
	
	public EvenChceker(IntGenerator genertor, int id){
		this.genertor = genertor;
		this.id = id;
	}
	
	@Override
	public void run() {
		
		while(!genertor.isCanceled()){
			
			int var = genertor.next();
			if(var % 2 != 0){
				System.out.println("id " + id + "   " + var + "not even!");
				genertor.cancel();
			}
		}
	}
	

	public static void test(IntGenerator genertor, int id){
		
		ExecutorService exec = Executors.newCachedThreadPool();
		
		for(int i = 0; i< id; i++){
			exec.execute(new EvenChceker(genertor, i));
		}
		exec.shutdown();
	}
	
	public static void test(IntGenerator genertor){
		
		test(genertor, 10);
	}
	
	public static void main(String[] args) {
		EvenChceker.test(new SynchronizedEvenGenerator());
	}
	
}
