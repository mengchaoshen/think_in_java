package com.smc.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ExplicitPairManager1 extends PairManager {

	private Lock lock = new ReentrantLock();

	@Override
	public synchronized void increment() {

		lock.lock();
		try {
			p.incrementX();
			p.incrementY();
			store(getPair());
		} finally {
			lock.unlock();
		}
	}
}

class ExplicitPairManager2 extends PairManager {

	private Lock lock = new ReentrantLock();

	@Override
	public void increment() {
		Pair temp = null;
		lock.lock();
		try {
			p.incrementX();
			p.incrementY();
			temp = getPair();
		} finally {
			lock.unlock();
		}
		store(temp);
	}
}

