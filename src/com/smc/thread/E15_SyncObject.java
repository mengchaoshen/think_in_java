package com.smc.thread;

public class E15_SyncObject {

	
	
	public static void main(String[] args) throws InterruptedException {

		final SingleSynch singleSynch = new SingleSynch();
		final TripleSync tripleSync = new TripleSync();
		System.out.println("Test Single ..");
		Thread t1 = new Thread(){
			@Override
			public void run() {
				singleSynch.f();
			}
		};
		t1.start();
		Thread t2 = new Thread(){
			@Override
			public void run() {
				singleSynch.g();
			}
		};
		t2.start();
		singleSynch.h();
		t1.join();
		t2.join();
		
		System.out.println("Test Triple ..");
		Thread t3 = new Thread(){
			@Override
			public void run() {
				tripleSync.f();
			}
		};
		t3.start();
		Thread t4 = new Thread(){
			@Override
			public void run() {
				tripleSync.g();
			}
		};
		t4.start();
		tripleSync.h();
		
	}

}

class SingleSynch{
	public synchronized void f(){
		for(int i = 0; i< 5; i++){
			System.out.println("f()");
			Thread.yield();
		}
	}
	
	public synchronized void g(){
		for(int i = 0; i< 5; i++){
			System.out.println("g()");
			Thread.yield();
		}
	}
	
	public synchronized void h(){
		for(int i = 0; i< 5; i++){
			System.out.println("h()");
			Thread.yield();
		}
	}
}

class TripleSync{
	
	private Object syncObjH = new Object();
	private Object syncObjG = new Object();
	
	public synchronized void f(){
		for(int i = 0; i< 5; i++){
			System.out.println("f()");
			Thread.yield();
		}
	}
	
	public void g(){
		synchronized (syncObjG) {
			for(int i = 0; i< 5; i++){
				System.out.println("g()");
				Thread.yield();
			}
		}
	}
	
	public void h(){
		synchronized (syncObjH) {
			for(int i = 0; i< 5; i++){
				System.out.println("h()");
				Thread.yield();
			}
		}
	}
	
}