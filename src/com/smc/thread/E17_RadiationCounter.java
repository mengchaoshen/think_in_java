package com.smc.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class E17_RadiationCounter {

	public static void main(String[] args) throws InterruptedException {

		ExecutorService exec = Executors.newCachedThreadPool();
		for(int i = 0; i< 5; i++){
			exec.execute(new Sensor(i));
		}
		TimeUnit.SECONDS.sleep(3);
		Sensor.cancel();
		exec.shutdown();
		if(!exec.awaitTermination(250, TimeUnit.MILLISECONDS)){
			System.out.println("Some tasks were not terminated!");
		}
		System.out.println("Total: " + Sensor.getTotalCount());
		System.out.println("Sum of Sensors: " + Sensor.sumSenors());
	}

}

//class Count{
//	
//	private int count = 0;
//	private Random rand = new Random(47);
//	public synchronized int increment(){
//		int temp = count;
//		if(rand.nextBoolean()){
//			Thread.yield();
//		}
//		return count=++temp;
//	}
//	
//}

class Sensor implements Runnable{

	private static Random rand = new Random(47);
	private static Count count = new Count();
	private static List<Sensor> sensors = new ArrayList<Sensor>();
	private int number;
	private int id;
	private static volatile boolean canceled = false;
	
	public Sensor(int id){
		this.id = id;
		sensors.add(this);
	}
	
	public static void cancel(){
		canceled = true;
	}
	
	public synchronized int getValue(){
		return number;
	}
	
	@Override
	public String toString() {
		return "Sensor" + id + ": " + getValue();
	}
	
	public static int getTotalCount(){
		return count.value();
	}
	
	public static int sumSenors(){
		int sum = 0;
		for(Sensor sensor : sensors){
			sum += sensor.getValue();
		}
		return sum;
	}
	
	@Override
	public void run() {
		
		while(!canceled){
			if(rand.nextInt(5) == 0){
				synchronized (this) {
					++number;
				}
				count.increment();
			}
			try {
				TimeUnit.MILLISECONDS.sleep(100);
			} catch (InterruptedException e) {
				System.out.println("sleep interrupted");
			}
		}
		
	}
	
}

