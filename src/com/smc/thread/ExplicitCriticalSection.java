package com.smc.thread;

public class ExplicitCriticalSection {

	public static void main(String[] args) {
		PairManager pman1 = new ExplicitPairManager1(),
		pman2 = new ExplicitPairManager2();

		CriticalSection.testApproaches(pman1, pman2);
		
	}
}
