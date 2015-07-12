package com.smc.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/****************** Exercise 10 *****************
 * Modify Exercise 5 following the example of the
 * ThreadMethod class, so that runTask() takes an
 * argument of the number of Fibonacci numbers to sum,
 * and each time you call runTask() it returns
 * the Future produced by the call to submit().
 ***********************************************/
public class FibnacciSum2 {

	private static ExecutorService exec;

	private static synchronized int fib(int n) {
		if (n < 2) {
			return 1;
		}
		return fib(n - 2) + fib(n - 1);
	}

	public static synchronized Future<Integer> runTask(final int n) {
		assert exec != null;
		return exec.submit(new Callable<Integer>() {

			@Override
			public Integer call() throws Exception {
				int sum = 0;
				for (int i = 0; i < n; i++) {
					sum += fib(i);
				}
				return sum;
			}
		});
	}

	public static synchronized void init() {
		if (null == exec) {
			exec = Executors.newCachedThreadPool();
		}
	}

	public static synchronized void shundown() {
		if (null != exec) {
			exec.shutdown();
		}
		exec = null;
	}

	public static void main(String[] args) {

		List<Future<Integer>> results = new ArrayList<Future<Integer>>();
		FibnacciSum2.init();
		for (int i = 1; i < 6; i++) {
			results.add(FibnacciSum2.runTask(i));
		}
		Thread.yield();
		FibnacciSum2.shundown();
		try {
			for (Future<Integer> f : results) {
				System.out.println(f.get());
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}

}
