package com.smc.thread;

public class SerialNumberGenerator {

	private static volatile int serialNumber = 0;
	
	public synchronized static int nextSerialNumber(){
		return serialNumber++;
	}
	
	public static void main(String[] args) {
		int index = 1;
		int len = 10;
		index = ++ index % len;
		System.out.println(index);
	}
}
