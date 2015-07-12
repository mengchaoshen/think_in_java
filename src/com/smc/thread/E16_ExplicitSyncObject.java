package com.smc.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class E16_ExplicitSyncObject {

	public static void main(String[] args) throws InterruptedException {
		
		final ExplicitSingleSynch explicitSingleSynch = new ExplicitSingleSynch();
		final ExplicitTripleSynch explicitTripleSynch = new ExplicitTripleSynch();
		System.out.println("Test ExplicitSingleSynch..");
		Thread t1 = new Thread(){
			public void run() {
				explicitSingleSynch.f();
			};
		};
		t1.start();
		Thread t2 = new Thread(){
			public void run() {
				explicitSingleSynch.g();
			};
		};
		t2.start();
		explicitSingleSynch.h();
		t1.join();
		t2.join();
		
		System.out.println("Test ExplicitTripleSynch..");
		Thread t3 = new Thread(){
			public void run() {
				explicitTripleSynch.f();
			};
		};
		t3.start();
		Thread t4 = new Thread(){
			public void run() {
				explicitTripleSynch.g();
			};
		};
		t4.start();
		explicitTripleSynch.h();

	}

}

class ExplicitSingleSynch{
	
	private Lock lock = new ReentrantLock();
	
	public void f(){
		lock.lock();
		try {
			for(int i = 0; i< 5; i++){
				System.out.println("f()");
				Thread.yield();
			}
		} finally {
			lock.unlock();
		}
	}
	
	public void g(){
		lock.lock();
		try {
			for(int i = 0; i< 5; i++){
				System.out.println("g()");
				Thread.yield();
			}
		} finally {
			lock.unlock();
		}
	}
	
	public void h(){
		lock.lock();
		try {
			for(int i = 0; i< 5; i++){
				System.out.println("h()");
				Thread.yield();
			}
		} finally {
			lock.unlock();
		}
	}
}

class ExplicitTripleSynch{
	
	private Lock lockF = new ReentrantLock();
	private Lock lockG = new ReentrantLock();
	private Lock lockH = new ReentrantLock();
	
	public void f(){
		lockF.lock();
		try {
			for(int i = 0;i< 5;i++){
				System.out.println("f()");
				Thread.yield();
			}
		} finally {
			lockF.unlock();
		}
	}
	
	public void g(){
		lockG.lock();
		try {
			for(int i = 0;i< 5;i++){
				System.out.println("g()");
				Thread.yield();
			}
		} finally {
			lockG.unlock();
		}
	}
	
	public void h(){
		lockH.lock();
		try {
			for(int i = 0;i< 5;i++){
				System.out.println("h()");
				Thread.yield();
			}
		} finally {
			lockH.unlock();
		}
	}
	
}
