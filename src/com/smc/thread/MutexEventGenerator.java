package com.smc.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MutexEventGenerator extends IntGenerator{

	private Lock lock = new ReentrantLock();
	
	private int currentEvenValue = 0;
	
	public static void main(String[] args) {

		EvenChceker.test(new MutexEventGenerator());
	}

	@Override
	public int next() {
		
		try {
			lock.lock();
			++currentEvenValue;
			Thread.yield();
			++currentEvenValue;
			return currentEvenValue;
		} finally  {
			lock.unlock();
		}
		
	}

}
