package com.smc.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class E18_Interruption {

	public static void main(String[] args) throws InterruptedException {

		ExecutorService exec = Executors.newCachedThreadPool();
		Future<?> f = exec.submit(new Task());
		
		TimeUnit.SECONDS.sleep(1);
		f.cancel(true);
	}

}

class NonTask{
	
	static void method() throws InterruptedException{
		TimeUnit.SECONDS.sleep(60);
	}
	
}

class Task implements Runnable{

	@Override
	public void run() {
		try {
			NonTask.method();
		} catch (InterruptedException e) {
			System.out.println(e.toString());
		}
	}
	
}

