package com.smc.thread;

public class EvenGenertor extends IntGenerator{

	private int currentEvenValue = 0;
	
	@Override
	public int next() {
		
		++currentEvenValue;//Danger point here
		Thread.yield();
		++currentEvenValue;
		return currentEvenValue;
	}

}
