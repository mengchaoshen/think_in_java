package com.smc.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableDemo {

	public static void main(String[] args) {

//		ExecutorService exec = Executors.newCachedThreadPool();
//		List<Future<String>> results = new ArrayList<Future<String>>();
//		for(int i =0; i<10;i++){
//			results.add(exec.submit(new TaskWithResult(i)));
//		}
//		for(Future<String> fs : results){
//			try {
//				System.out.println(fs.get());
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			} catch (ExecutionException e) {
//				e.printStackTrace();
//			}finally{
//				exec.shutdown();
//			}
//		}
		
		ExecutorService exec = Executors.newCachedThreadPool();
		List<Future<Integer>> results = new ArrayList<Future<Integer>>();
		for(int i =1; i<=10;i++){
			results.add(exec.submit(new FibonacciSum(i)));
		}
		for(Future<Integer> fs : results){
			try {
				System.out.println(fs.get());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}finally{
				exec.shutdown();
			}
		}
	}

}
